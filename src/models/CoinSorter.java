package models;

import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

public abstract class CoinSorter {
	protected Currency activeCurrency;
	protected int lower_limit;
	protected int upper_limit;

	public Currency getCurrency() {
		return activeCurrency;
	}

	public void setCurrency(final Currency currency) {
		activeCurrency = currency;
	}

	public abstract CoinSack calculate(final long pennies,
			final CoinDenomination coin_denomination) throws InvalidDenominationException, OutOfRangeException;

	protected CoinSorter(Currency curr) {
		activeCurrency = curr;
		lower_limit = 1;
		upper_limit = 10000;
	}

	public int getLowerLimit() {
		return lower_limit;
	}

	public void setLowerLimit(final int lower_lim) throws OutOfRangeException{
		if(lower_lim <= 0 || lower_lim > upper_limit) {
			throw new OutOfRangeException();
		}
		this.lower_limit = lower_lim;
	}

	public int getUpperLimit() {
		return upper_limit;
	}

	public void setUpperLimit(final int upper_lim) {
		this.upper_limit = upper_lim;
	}

}
