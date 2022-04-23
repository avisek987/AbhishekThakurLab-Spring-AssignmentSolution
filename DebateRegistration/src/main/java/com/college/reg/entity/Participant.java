package com.college.reg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String department;
	private String country;

	public Participant() {

	}

	public Participant(String name, String department, String country) {
		this.id = 0;
		this.name = name;
		this.department = department;
		this.country = country;
	}
}
