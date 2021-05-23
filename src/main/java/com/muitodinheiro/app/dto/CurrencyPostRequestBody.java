package com.muitodinheiro.app.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.muitodinheiro.app.entities.Currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyPostRequestBody {
	@Id
	@Schema(description = "Código ISO 4217 da moeda", example = "BRL")
	@NotBlank
	private String code;
	
	@NotBlank
	@Schema(description = "Nome da moeda por extenso", example = "Real Brasileiro")
	private String name;
	
	@NotNull
	@Schema(description = "Cotação da moeda em BRL (Real Brasileiro)", example = "1.23")
	private Double priceQuote;
	
	public CurrencyPostRequestBody(Currency currency) {
		this.name = currency.getName();
		this.code = currency.getCode();
		this.priceQuote = currency.getPriceQuote();
	}
}
