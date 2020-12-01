package com.bartoszwalter.students.bank.operation.impl;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;

public class Transfer implements BankingOperation {
	
	private Account from;
	private Account to;
	private int value;

	public Transfer(Account from, Account to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}

	@Override
	public void execute() throws BankingException {
		from.__subtractFromBalance(value);
		to.__addToBalance(value);
		
		from.__addToHistory(this);
		to.__addToHistory(this);
	}
	
	public String toString() {
		return "From: " + from.id() + " to: " + to.id() + " amount: " + value;
	}

	@Override
	public String id() {
		return "TRAN";
	}

}
