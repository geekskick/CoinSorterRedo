package models;

import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

import org.apache.logging.log4j.*;

public class CoinSorter {
	private Currency activeCurrency;
	private int lowerLimit;
	private int upperLimit;
	private SortingStrategy sortingStrategy;

	public SortingStrategy getSortingStrategy() {
		return sortingStrategy;
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

		if (!isInRange(pennies)) {
			LogManager.getRootLogger().trace(
					pennies + " is out of the limits of the coin sorter");
			throw new OutOfRangeException();
		}

		return sortingStrategy.calculate(pennies, coin, activeCurrency);
	}

	public void setSortingStrategy(SortingStrategy strat) {
		LogManager.getRootLogger()
				.trace("Setting new sorting strategy to " + strat);
		sortingStrategy = strat;
	}

	public CoinSorter(Currency curr, SortingStrategy strat) {
		activeCurrency = curr;
		lowerLimit = 1;
		upperLimit = 10000;
		sortingStrategy = strat;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(final int lowerLim) throws OutOfRangeException {
		if (isTooHigh(lowerLim) || lowerLim < 0) {
			LogManager.getRootLogger()
					.trace(lowerLim + " is out of range of " + lowerLimit);
			throw new OutOfRangeException();
		}
		lowerLimit = lowerLim;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(final int upperLim) throws OutOfRangeException {
		if (isTooLow(upperLim)) {
			LogManager.getRootLogger()
					.trace(upperLim + " is out of range of " + upperLimit);
			throw new OutOfRangeException();
		}
		upperLimit = upperLim;
	}

	private boolean isInRange(final int value) {
		return !(isTooLow(value) || isTooHigh(value));
	}

	private boolean isTooLow(final int value) {
		return (value < lowerLimit) || (value <= 0);
	}

	private boolean isTooHigh(final int value) {
		return value > upperLimit;
	}

}
