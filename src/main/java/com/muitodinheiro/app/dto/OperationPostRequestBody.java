package com.muitodinheiro.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.muitodinheiro.app.entities.Customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OperationPostRequestBody {
	
	@NotNull
	private Customer customer;
	
	@NotBlank
	@Schema(description = "Código ISO 4217 da moeda de origem", example = "BRL")
	private String currencyIn;
	
	@NotBlank
	@Schema(description = "Código ISO 4217 da moeda de destino", example = "USD")
	private String currencyOut;
	
	@NotNull
	@Schema(description = "Valor que o cliente quer fazer o câmbio", example = "1234.56")
	private Double originalPrice;	
	
	@Schema(description = "Valor da taxa de câmbio. O valor padrão é 10%", example = "0.1")
	private Double serviceBill = 0.1;

}
