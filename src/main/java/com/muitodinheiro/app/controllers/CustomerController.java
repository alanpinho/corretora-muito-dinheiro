package com.muitodinheiro.app.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muitodinheiro.app.dto.CustomerPostRequestBody;
import com.muitodinheiro.app.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
	
	private CustomerService customerService;
	
	@PostMapping("/new")
	@Operation(summary = "Adicionar um novo cliente ao banco")
	public ResponseEntity<CustomerPostRequestBody> newCustomer(@RequestBody @Valid CustomerPostRequestBody customerPostRequestBody) {
		customerService.save(customerPostRequestBody);
		return new ResponseEntity<>(customerPostRequestBody, HttpStatus.CREATED);
	}
}
