package com.muitodinheiro.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_operation")
public class Operation{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull
	private String currencyIn;
	
	//@NotNull
	private String currencyOut;
	
	private Date operationDate = new Date();
	
	//@NotNull
	private Double originalPrice;
	
	private String convertedPrice;
	
	private Double serviceBill = 0.1;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")	
	private Customer customer;
	
}
