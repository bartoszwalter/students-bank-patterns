package com.bartoszwalter.students.bank.debit;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.interest.Interest;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.operation.BankingOperation;
import com.bartoszwalter.students.bank.report.Report;

public class DebitAccount implements Account {
	
	private Account account;
	private int maxDebit = 0;
	private int debit;
	
	public DebitAccount(Account account, int maxDebit) {
		this.account = account;
		this.maxDebit = maxDebit;
	}

	@Override
	public String id() {
		return account.id();
	}

	@Override
	public String owner() {
		return account.owner();
	}

	@Override
	public int balance() {
		return account.balance() - debit;
	}

	public int maxDebit() {
		return maxDebit;
	}

	@Override
	public void printHistory() {
		account.printHistory();

	}

	@Override
	public void __addToBalance(int value) {
		if (debit > 0) {
			if (value <= debit) {
				debit -= value;
			} else {
				account.__addToBalance(value - debit);
				debit = 0;
			}
		} else {
			account.__addToBalance(value);
		}
	}

	@Override
	public void __subtractFromBalance(int value) throws BankingException {
		if (debit > maxDebit)
			throw new BankingException("Debet przekracza limit");
		if (account.balance() < value) {
			debit = value - account.balance();
			account.__subtractFromBalance(account.balance());
		} else {
			account.__subtractFromBalance(value);
		}
	}

	@Override
	public int calculateInterest() {
		return account.calculateInterest();
	}

	@Override
	public boolean accept(Report report) {
		return account.accept(report);
	}

	@Override
	public void __addToHistory(BankingOperation operation) {
		account.__addToHistory(operation);
	}

	@Override
	public void __setInterest(Interest interest) {
		account.__setInterest(interest);
		
	}
}