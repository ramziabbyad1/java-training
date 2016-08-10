package com.examples.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="C")
public class ContractEmployee extends Employee{
	private float payPerHouse;
	private String contractPeriod;
	public float getPayPerHouse() {
		return payPerHouse;
	}
	public void setPayPerHouse(float payPerHouse) {
		this.payPerHouse = payPerHouse;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
}
