package com.muitodinheiro.app.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerPostRequestBody {
	
	@NotBlank
	@Schema(description = "Nome do cliente", example = "Alan Pinho")
	private String name;
	
}
