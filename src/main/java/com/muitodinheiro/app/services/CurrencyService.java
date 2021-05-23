package com.muitodinheiro.app.services;

import org.springframework.stereotype.Service;

import com.muitodinheiro.app.dto.CurrencyPostRequestBody;
import com.muitodinheiro.app.entities.Currency;
import com.muitodinheiro.app.repositories.CurrencyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrencyService {
	
	private CurrencyRepository currencyRepository;
	
	public void save(CurrencyPostRequestBody currencyPostRequestBody) {
		
		Currency currency = new Currency();
		currency.setName(currencyPostRequestBody.getName());
		currency.setCode(currencyPostRequestBody.getCode());
		currency.setPriceQuote(currencyPostRequestBody.getPriceQuote());
		
		currencyRepository.save(currency);
	}
}
