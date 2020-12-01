package com.bartoszwalter.students.bank;

import com.bartoszwalter.students.bank.model.Account;
import com.bartoszwalter.students.bank.model.Bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

	Bank bank = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		bank = new Bank();
	}

	public void testZalozRachunek() {
		Account rachunek = bank.createAccount("111", "Jan", "Kowalski");
		assertEquals("111", rachunek.id());
		
		rachunek = bank.findAccount("111");
		assertNotNull(rachunek);
		assertEquals("111", rachunek.id());
	}
}
