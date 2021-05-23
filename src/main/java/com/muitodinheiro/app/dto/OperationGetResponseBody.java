package com.muitodinheiro.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OperationGetResponseBody {
	
	@NotBlank
	private Double originalPrice;
	
	@NotBlank
	private String convertedPrice;
	
	private Double serviceBill = 0.1;
}
