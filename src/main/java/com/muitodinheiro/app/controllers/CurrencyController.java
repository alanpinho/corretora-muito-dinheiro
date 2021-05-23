package com.muitodinheiro.app.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muitodinheiro.app.dto.CurrencyPostRequestBody;
import com.muitodinheiro.app.services.CurrencyService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/currency")
@AllArgsConstructor
public class CurrencyController {
	
	private CurrencyService currencyService;
	
	@PostMapping("/new")
	@Operation(summary = "Adicionar uma nova moeda ao banco ou sobrescrever o valor de uma existente")
	public ResponseEntity<CurrencyPostRequestBody> registerCurrency(@RequestBody @Valid CurrencyPostRequestBody currencyPostRequestBody) {
		currencyService.save(currencyPostRequestBody);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
