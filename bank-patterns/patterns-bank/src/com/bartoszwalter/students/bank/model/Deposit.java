package com.bartoszwalter.students.bank.model;

import com.bartoszwalter.students.bank.report.Report;

public class Deposit implements BankingProduct{
	
	private String id;
	private int value;

	public Deposit(String id, int value) {
		this.id = id;
		this.value = value;
	}
	
	public void close(Account acc) {
		acc.__addToBalance((int) (value + 0.07 * value));
		this.value = 0;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public boolean accept(Report report) {
		report.visit(this);
		return true;
	}

}
