package com.muitodinheiro.app.controllers;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muitodinheiro.app.dto.OperationPostRequestBody;
import com.muitodinheiro.app.entities.Operation;
import com.muitodinheiro.app.services.OperationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/operation")
@AllArgsConstructor
public class OperationController {
	
	private OperationService operationService;
	
	@GetMapping("/all")
	@io.swagger.v3.oas.annotations.Operation(summary = "Listar todas as operações que estão no banco de forma paginada",
	description = "o tamanho padrão é 20 por página, mas, você pode alterar esse padrão nos campos presentes")
	public ResponseEntity<Page<Operation>> listAll(@ParameterObject Pageable pageable){
		Page<Operation> listAllPageable = operationService.listAll(pageable);
		return ResponseEntity.ok(listAllPageable);
	}
	
	@PostMapping("/new")
	@io.swagger.v3.oas.annotations.Operation(summary = "Fazer uma nova operação de câmbio")
	public ResponseEntity<OperationPostRequestBody> save(@Valid @RequestBody OperationPostRequestBody operationPostRequestBody){
		Double convertedValue = operationService.finalValue(operationPostRequestBody);
		if(convertedValue != null) {
			operationService.saveOperation(operationPostRequestBody);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(operationPostRequestBody, HttpStatus.BAD_REQUEST);
	}

}
