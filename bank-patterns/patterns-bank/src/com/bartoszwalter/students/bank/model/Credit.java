package com.bartoszwalter.students.bank.model;

import com.bartoszwalter.students.bank.report.Report;

public class Credit implements BankingProduct {
	
	private int balance;
	private String id;
	
	public Credit(String id) {
		this.id = id;
	}
	
	public int getBalance() {
		return balance;
	}

	@Override
	public boolean accept(Report report) {
		report.visit(this);
		return true;
	}
}
