package com.bartoszwalter.students.bank.operation.impl;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.interest.Interest;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;

public class ChangeOfInterest implements BankingOperation {
	
	private Account acc;
	private Interest interest;

	public ChangeOfInterest(Account acc, Interest interest) {
		this.acc = acc;
		this.interest = interest;
	}

	@Override
	public void execute() throws BankingException {
		acc.__setInterest(interest);

		acc.__addToHistory(this);
	}
	
	public String toString() {
		return "On: " + acc.id() + " new interest: " + interest;
	}

	@Override
	public String id() {
		return "INT";
	}

}
