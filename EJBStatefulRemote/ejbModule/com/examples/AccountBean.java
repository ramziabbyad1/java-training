package com.examples;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
public class AccountBean implements AccountBeanRemote {
	double balance = 0;

    public AccountBean() {}

	@Override
	public double deposit(double amt) {
		balance += amt;
		return balance;
	}

	@Override
	public double withdraw(double amt) {
		balance -= amt;
		return balance;
	}

}
