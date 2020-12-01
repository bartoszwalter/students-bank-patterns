package com.bartoszwalter.students.bank.operation.impl;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;

public class Withdrawal implements BankingOperation {
	
	private Account acc;
	private int value;

	public Withdrawal(Account acc, int value) {
		this.acc = acc;
		this.value = value;
	}

	@Override
	public void execute() throws BankingException {
		acc.__subtractFromBalance(value);
		acc.__addToHistory(this);
	}
	
	public String toString() {
		return "From: " + acc.id() + " amount: " + value;
	}

	@Override
	public String id() {
		return "OUT";
	}

}
