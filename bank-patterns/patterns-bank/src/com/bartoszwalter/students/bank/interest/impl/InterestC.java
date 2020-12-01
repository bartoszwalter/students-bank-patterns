package com.bartoszwalter.students.bank.interest.impl;

import com.bartoszwalter.students.bank.interest.Interest;

public class InterestC implements Interest {

	@Override
	public int calculate(int value) {
		return (int) (0.03 * value);
	}

	@Override
	public String description() {
		return "3%";
	}

}
