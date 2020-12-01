package com.bartoszwalter.students.bank.operation.impl;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;

public class CapitalizationOfInterest implements BankingOperation {
	
	private Account acc;
	private int interestAmount = 0;

	public CapitalizationOfInterest(Account acc) {
		this.acc = acc;
	}

	@Override
	public void execute() throws BankingException {
		int interest = acc.calculateInterest();
		acc.__addToBalance(interest);
		
		acc.__addToHistory(this);
	}
	
	public String toString() {
		return "On: " + acc.id() + " interest: " + interestAmount;
	}

	@Override
	public String id() {
		return "CAP";
	}

}
