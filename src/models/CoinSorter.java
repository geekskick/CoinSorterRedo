package models;

import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

import org.apache.logging.log4j.*;

public class CoinSorter {
	private Currency activeCurrency;
	private Limits limits;
	private SortingStrategy sortingStrategy;

	public Limits getLimits() {
		return limits;
	}

	public SortingStrategy getSortingStrategy() {
		return sortingStrategy;
	}

	public void setSortingStrategy(SortingStrategy strat) {
		LogManager.getRootLogger()
				.trace("Setting new sorting strategy to " + strat);
		sortingStrategy = strat;
	}

	public Currency getCurrency() {
		return activeCurrency;
	}

	public void setCurrency(final Currency currency) {
		activeCurrency = currency;
	}

	public CoinSack calculate(final int pennies, final CoinDenomination coin)
			throws InvalidDenominationException, OutOfRangeException {
		if (!activeCurrency.isValidCoin(coin)) {
			LogManager.getRootLogger()
					.trace(coin + " isn't in the active currency "
							+ activeCurrency.getCode());
			throw new InvalidDenominationException();
		}

		if (!limits.inRange(pennies)) {
			LogManager.getRootLogger().trace(
					pennies + " is out of the limits of the coin sorter");
			throw new OutOfRangeException();
		}

		return sortingStrategy.calculate(pennies, coin, activeCurrency);
	}

	public CoinSorter(Currency curr, SortingStrategy strat)
			throws OutOfRangeException {
		activeCurrency = curr;
		limits = new Limits(1, 10000);
		sortingStrategy = strat;
	}

}
