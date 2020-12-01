package com.bartoszwalter.students.bank.operation;

import com.bartoszwalter.students.bank.BankingException;

/**
 * @author bartoszwalter
 *
 */
public interface BankingOperation {
	/**
	 * @return account identifier
	 */
	public String id();
	/**
	 * execute the command
	 * @throws BankingException on failure
	 */
	public void execute() throws BankingException;

}
