package com.bartoszwalter.students.bank.operation.impl;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;

public class Payment implements BankingOperation {
	
	private Account acc;
	private int value;

	public Payment(Account acc, int value) {
		this.acc = acc;
		this.value = value;
	}

	@Override
	public void execute() throws BankingException {
		acc.__addToBalance(value);
		acc.__addToHistory(this);
	}
	
	public String toString() {
		return "To: " + acc.id() + " amount: " + value;
	}

	@Override
	public String id() {
		return "IN";
	}

}
