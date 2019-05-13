package com.broodcamp.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private int age;
	private String email;
	
	@Transient
	private Long entityId;

	public Customer(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public Long getEntityId() {
		return id;
	}
}
