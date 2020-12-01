package com.bartoszwalter.students.bank.report.impl;

import java.util.ArrayList;
import java.util.List;

import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.model.BankingProduct;
import com.bartoszwalter.students.bank.model.Credit;
import com.bartoszwalter.students.bank.model.Deposit;
import com.bartoszwalter.students.bank.report.Report;

public class OnlyDepositsOver2000Report implements Report {
	private List<BankingProduct> products = new ArrayList<BankingProduct>();
	
	public void visit(Account account) {
	}
	
	public void visit(Deposit deposit) {
		if (deposit.getValue() > 2000)
			products.add(deposit);
	}

	@Override
	public void visit(Credit credit) {
	}
	
	@Override
	public boolean requiresPermission() {
		return true;
	}
}
