package com.examples;

import javax.ejb.Remote;

@Remote
public interface AccountBeanRemote {
	public double deposit(double amt);
	public double withdraw(double amt);
}
