package com.muitodinheiro.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_currency")
public class Currency {
	
	@Id
	private String code;
	
	private String name;
	
	private Double priceQuote;

}
