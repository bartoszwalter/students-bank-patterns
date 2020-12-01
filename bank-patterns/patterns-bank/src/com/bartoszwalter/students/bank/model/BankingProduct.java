package com.bartoszwalter.students.bank.model;

import com.bartoszwalter.students.bank.report.Report;

public interface BankingProduct {
	/**
	 * @param report
	 * @return true if the report is accepted by the banking product
	 */
	public boolean accept(Report report);
}
