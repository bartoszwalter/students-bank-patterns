package com.bartoszwalter.students.bank.model;

import java.util.ArrayList;
import java.util.List;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.interest.Interest;
import com.bartoszwalter.students.bank.interest.impl.InterestA;
import com.bartoszwalter.students.bank.operation.BankingOperation;
import com.bartoszwalter.students.bank.report.Report;

public class NonDebitAccount implements BankingProduct, Account {
	private String id;
	private String givenName, familyName;
	private int balance;
	private List history = new ArrayList();
	private Interest interest;
	
	/**
	 * Utworzenie rachunku
	 * @param id
	 * @param givenName
	 * @param familyName
	 */
	public NonDebitAccount(String id, String givenName, String familyName) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.balance = 0;
		interest = new InterestA();
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#id()
	 */
	@Override
	public String id() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#owner()
	 */
	@Override
	public String owner() {
		return givenName + " " + familyName;
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#balance()
	 */
	@Override
	public int balance() {
		return balance;
	}	

	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#printHistory()
	 */
	@Override
	public void printHistory() {
		System.out.println(history);
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#credit(int)
	 */
	@Override
	public void __addToBalance(int amount) {
		balance += amount;
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#debit(int)
	 */
	@Override
	public void __subtractFromBalance(int amount) throws BankingException {
		if (balance < amount) 
			throw new BankingException("Brak środków na rachunku " + id());
		
		balance -= amount;
	}
	
	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#calculateInterest()
	 */
	@Override
	public int calculateInterest() {
		int value = interest.calculate(balance);
		
		history.add("Naliczono odsetki w kwocie " + value);
		
		return value;
	}

	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#accept(com.bartoszwalter.students.bank.report.Report)
	 */
	@Override
	public boolean accept(Report report) {
		if (report.requiresPermission())
			return false;
		report.visit(this);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.bartoszwalter.students.bank.model.Account#addHistory(com.bartoszwalter.students.bank.operation.Operation)
	 */
	@Override
	public void __addToHistory(BankingOperation operation) {
		history.add(operation);		
	}

	@Override
	public void __setInterest(Interest interest) {
		if (interest != null)
			this.interest = interest;
	}
}
