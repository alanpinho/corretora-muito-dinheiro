package com.muitodinheiro.app.services;

import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muitodinheiro.app.dto.OperationPostRequestBody;
import com.muitodinheiro.app.entities.Operation;
import com.muitodinheiro.app.repositories.CurrencyRepository;
import com.muitodinheiro.app.repositories.OperationRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class OperationService {
	
	private CurrencyRepository currencyRepository;
	
	private OperationRepository operationRepository;
	
	public Page<Operation> listAll(Pageable pageable) {
		return operationRepository.findAll(pageable);
	}

	// Converte o valor de origem para valor de destino, sem a taxa de 10%
	public Double convertValue(Double originalPrice, Double quotePriceOut, Double quotePriceIn) {
		Double convertedValue = 0.0;
		
		convertedValue = originalPrice * (quotePriceIn / quotePriceOut); //valor convertido sem a taxa de 10%		
		log.info("O valor convertido é " + convertedValue);				
		return convertedValue;
	}	
	
	// Verifica se as moedas de origem e destino existem no banco e calcula o valor final, com a cobrança de 10% de taxa
	public Double finalValue(OperationPostRequestBody operationPostRequestBody){		
		// Pega a cotação da moeda de entrada e de saída no banco de dados. O valor da cotação das moedas no banco está em BRL
		Double priceQuoteCurrencyIn = currencyRepository.findById(operationPostRequestBody.getCurrencyIn())
				.map(x -> x.getPriceQuote())
				.orElse(9999999.99);
		
		Double priceQuoteCurrencyOut = currencyRepository.findById(operationPostRequestBody.getCurrencyOut())
				.map(x -> x.getPriceQuote())
				.orElse(9999999.99);
		
		// Verificação se a moeda existe no banco de dados. Se não existir, o código para aqui e nada é salvo
		if(priceQuoteCurrencyIn == 9999999.99 || priceQuoteCurrencyOut == 9999999.99){
			return null;
		}
		
		// Se a moeda existir, ela será convertida da moeda de entrada para a moeda de saída aqui
		Double convertedValue = convertValue(operationPostRequestBody.getOriginalPrice(), priceQuoteCurrencyOut, priceQuoteCurrencyIn);
		Double finalValue = convertedValue - convertedValue * operationPostRequestBody.getServiceBill();
		
		return finalValue;		
	}
	
	
	// Arredonda o resultado da conversão para duas casas decimais e persiste a operação no banco
	public Operation saveOperation(OperationPostRequestBody operationPostRequestBody) {
				
		Double finalValue = finalValue(operationPostRequestBody);
		
		// Colocando o resultado da conversão em duas casas decimais
		DecimalFormat df = new DecimalFormat("####0.00");
		String finalValueWithCents = df.format(finalValue);
		
		Operation operation = new Operation();
		operation.setConvertedPrice(finalValueWithCents);
		operation.setCurrencyIn(operationPostRequestBody.getCurrencyIn());
		operation.setCurrencyOut(operationPostRequestBody.getCurrencyOut());
		operation.setOriginalPrice(operationPostRequestBody.getOriginalPrice());
		operation.setCustomer(operationPostRequestBody.getCustomer());
		operation.setOperationDate(new Date());
		operation.setServiceBill(operationPostRequestBody.getServiceBill());		
		operation.setConvertedPrice(finalValueWithCents);				

		operationRepository.save(operation);
		
		return operation;
	}

}
