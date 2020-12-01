package com.bartoszwalter.students.bank.model;

import java.util.HashMap;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.operation.BankingOperation;
import com.bartoszwalter.students.bank.operation.impl.Payment;
import com.bartoszwalter.students.bank.operation.impl.Withdrawal;
import com.bartoszwalter.students.bank.operation.impl.Transfer;

public class Bank {
	private HashMap accounts = new HashMap();

	/**
	 * Zak�adanie rachunku. Rachunek zostanie stworzony i zapami�tany przez bank.
	 * @param id
	 * @param name
	 * @param familyName
	 * @return
	 */
	public Account createAccount(String id, String name, String familyName) {
		Account acc = new NonDebitAccount(id, name, familyName);
		accounts.put(id, acc);
		return acc;
	}

	/**
	 * Wyszukiwanie rachunku
	 * @param id
	 * @return obiekt rachunku, je�eli zostanie znaleziony, i null, je�eli go nie ma
	 */	
	public Account findAccount(String id) {
		return (Account) accounts.remove(id);
	}
	
	/**
	 * Przelew w kwocie kwota z rachunku o numerze numer1 na rachunek o numerze numerw
	 * @param from
	 * @param to
	 * @param value
	 * @return -1, je�eli przelew si� nie powiedzie, 0 - je�eli przelew si� powiedzie
	 * @throws BankingException 
	 */
	public void transfer(String from, String to, int value) throws BankingException {
		Account accFrom = findAccount(from);
		Account accTo = findAccount(to);
		
		transfer(accFrom, accFrom, value);
	}
	
	/**
	 * Przelew w kwocie kwota z rachunku rach1 na rachunek rach2
	 * @param accFrom
	 * @param accFrom
	 * @param accTo
	 * @return
	 * @throws BankingException 
	 */
	public void transfer(Account accFrom, Account accTo, int value) throws BankingException {
		Transfer transfer = new Transfer(accFrom, accTo, value);
		handle(transfer);
	}
	
	public void income(Account acc, int value) throws BankingException {
		Payment payment = new Payment(acc, value);
		handle(payment);
	}
	
	public void outcome(Account acc, int value) throws BankingException {
		Withdrawal withdrawal = new Withdrawal(acc, value);
		handle(withdrawal);
	}
	
	public void handle(BankingOperation oper) throws BankingException {
		oper.execute();
	}
}