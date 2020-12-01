package com.bartoszwalter.students.bank.model;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.interest.Interest;
import com.bartoszwalter.students.bank.operation.BankingOperation;
import com.bartoszwalter.students.bank.report.Report;

public interface Account extends BankingProduct {

	/**
	 * Zwraca numer rachunku
	 * @return
	 */
	public abstract String id();

	/**
	 * Zwraca w�a�ciciela rachunu
	 * @return
	 */
	public abstract String owner();

	/** 
	 * Zwraca saldo rachunku
	 * @return
	 */
	public abstract int balance();

	/**
	 * Zwraca aktualn� warto�� dopuszczalnego debetu
	 * @return
	 */
	public abstract void printHistory();

	/**
	 * Wyświetla historię rachunku
	 *
	 */
	public abstract void __addToBalance(int amount);

	/**
	 * Wypłaca podaną kwotę z rachunku
	 * @param amount
	 */
	public abstract void __subtractFromBalance(int amount) throws BankingException;

	/**
	 * Zwraca wartość należnych odsetek: do 10000 - 1%, od 10000 do 50000 - 2%, powy�ej 50000 - 3%
	 * @return
	 */
	public abstract int calculateInterest();

	public abstract boolean accept(Report report);

	public abstract void __addToHistory(BankingOperation operation);

	public abstract void __setInterest(Interest interest);

}