package com.bartoszwalter.students.bank.interest.impl;

import com.bartoszwalter.students.bank.interest.Interest;

public class InterestA implements Interest {

	@Override
	public int calculate(int value) {
		if (value < 1000)
			return (int) (0.01 * value);
		if (value < 3000)
			return (int) (calculate(1000) + 0.02 * (value - 1000));
		else
			return (int) (calculate(3000) + 0.03 * (value - 3000));
	}

	@Override
	public String description() {
		return "<1000: 1%; <3000: 2%; >3000: 3%";
	}

}
