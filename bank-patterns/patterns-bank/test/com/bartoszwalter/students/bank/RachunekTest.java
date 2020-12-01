package com.bartoszwalter.students.bank;

import junit.framework.TestCase;

import com.bartoszwalter.students.bank.debit.DebitAccount;
import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.model.NonDebitAccount;

public class RachunekTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testDebitAccount() throws BankingException {
		Account nda = new NonDebitAccount("1", "Joe", "Doe");
		Account da = new DebitAccount(nda, 200);
		da.__addToBalance(100);
		da.__subtractFromBalance(200);
		assertEquals(0, nda.balance());
		assertEquals(-100, da.balance());
	}

	public void testDebitAccount2() throws BankingException {
		Account nda = new NonDebitAccount("1", "Joe", "Doe");
		Account da = new DebitAccount(nda, 200);
		da.__addToBalance(100);
		da.__subtractFromBalance(100);
		assertEquals(0, nda.balance());
		assertEquals(0, da.balance());
	}
}
