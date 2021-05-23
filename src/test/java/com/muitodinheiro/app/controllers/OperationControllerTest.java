package com.muitodinheiro.app.controllers;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.muitodinheiro.app.dto.OperationPostRequestBody;
import com.muitodinheiro.app.entities.Operation;
import com.muitodinheiro.app.services.OperationService;
import com.muitodinheiro.app.utils.OperationCreator;

@ExtendWith(SpringExtension.class)
class OperationControllerTest {
	
	@InjectMocks
	private OperationController operationController;
	
	@Mock
	private OperationService operationServiceMock;
	
	@BeforeEach
	void setUp(){
		PageImpl<Operation> operationPage = new PageImpl<>(List.of(OperationCreator.operationWithAllAtt()));
		BDDMockito.when(operationServiceMock.listAll(ArgumentMatchers.any())).thenReturn(operationPage);
		BDDMockito.when(operationServiceMock.saveOperation(ArgumentMatchers.any(OperationPostRequestBody.class)))
		.thenReturn(OperationCreator.operationWithAllAtt());
	}

	@Test
	@DisplayName("list returns list of operation when successful")
	void listAll_ReturnsListOfOperationsInsidePageObject_WhenSuccessful() {
		String expectedName = OperationCreator.operationWithAllAtt().getCustomer().getName();
		Page<Operation> operationPage = operationController.listAll(null).getBody();
		
		Assertions.assertThat(operationPage).isNotNull();
		Assertions.assertThat(operationPage.toList()).isNotEmpty().hasSize(1);		
		Assertions.assertThat(operationPage.toList().get(0).getCustomer().getName()).isEqualTo(expectedName);
		
		Assertions.assertThat(expectedName).isNull(); // como não atribuí nenhum nome no mock, o objeto mockado tem name null
		Assertions.assertThat(operationPage.toList().get(0).getId()).isNotNull(); // não é null pq há a annotation @GeneratedValue
	}
		
}
