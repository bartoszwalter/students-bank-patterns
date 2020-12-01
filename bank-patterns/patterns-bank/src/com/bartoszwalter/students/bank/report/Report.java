package com.bartoszwalter.students.bank.report;

import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.model.Credit;
import com.bartoszwalter.students.bank.model.Deposit;

public interface Report {
	public void visit(Account account);
	public void visit(Deposit deposit);
	public void visit(Credit credit);
	public boolean requiresPermission();
}
