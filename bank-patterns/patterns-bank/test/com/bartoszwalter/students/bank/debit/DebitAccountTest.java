package com.bartoszwalter.students.bank.debit;

import com.bartoszwalter.students.bank.BankingException;
import com.bartoszwalter.students.bank.model.NonDebitAccount;

import junit.framework.TestCase;

public class DebitAccountTest extends TestCase {
	
	private NonDebitAccount nda;
	private DebitAccount da;
	
	public void setUp() {
		nda = new NonDebitAccount("1", "Jan", "Kowalski");
		da = new DebitAccount(nda, 100);
	}
	
	public void testDebitAccount() throws BankingException {
		da.__addToBalance(100);
		da.__subtractFromBalance(200);
		
		assertEquals(-100, da.balance());
		assertEquals(0, nda.balance());
		assertEquals("Jan Kowalski", da.owner());
	}
}