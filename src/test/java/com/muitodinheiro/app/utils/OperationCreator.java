package com.muitodinheiro.app.utils;

import java.util.Date;

import com.muitodinheiro.app.entities.Customer;
import com.muitodinheiro.app.entities.Operation;

public class OperationCreator {
	
	public static Operation operationWithAllAtt() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	
	public static Operation operationWithoutId() {
		Operation op = new Operation();
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutCurrencyIn() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutCurrencyOut() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutCustomer() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutOperationDate() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOriginalPrice(1000.00);
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutOriginalPrice() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setServiceBill(0.1);
		
		return op;
	}
	
	public static Operation operationWithoutServiceBill() {
		Operation op = new Operation();
		op.setId(1L);
		op.setCurrencyIn("BRL");
		op.setCurrencyOut("USD");
		op.setCustomer(new Customer());
		op.setOperationDate(new Date());
		op.setOriginalPrice(1000.00);
		
		return op;
	}
	
}
