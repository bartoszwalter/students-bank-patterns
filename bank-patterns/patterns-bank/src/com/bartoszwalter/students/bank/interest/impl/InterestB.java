package com.bartoszwalter.students.bank.interest.impl;

import com.bartoszwalter.students.bank.interest.Interest;

public class InterestB implements Interest {

	@Override
	public int calculate(int value) {
		if (value < 2000)
			return (int) (0.02 * value);
		if (value < 10000)
			return (int) (calculate(10000) + 0.04 * (value - 10000));
		else
			return (int) (calculate(20000) + 0.05 * (value - 20000));
	}

	@Override
	public String description() {
		return "<2000: 2%; <10000: 4%; >20000: 5%";
	}

}
