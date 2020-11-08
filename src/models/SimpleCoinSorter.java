package models;

import java.util.logging.Logger;

import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

public final class SimpleCoinSorter extends CoinSorter {

	@Override
	public CoinSack calculate(final long pennies, final CoinDenomination coin)
			throws InvalidDenominationException, OutOfRangeException {
		if (!activeCurrency.isValidCoin(coin)) {
			throw new InvalidDenominationException();
		}
		if(pennies < lower_limit || pennies > upper_limit) {
			throw new OutOfRangeException();
		}

		final long whole_coins = pennies / coin.getValue();
		
		// Banks always win!
		final long single_units = (pennies % coin.getValue())
				/ activeCurrency.getUnitValue().getValue();
		final CoinSack cs = new CoinSack();

		Logger.getLogger(getClass().getSimpleName())
				.finest(((Long) pennies).toString() + " splits into "
						+ whole_coins + " coins of value " + coin.toString()
						+ ". With a remainder of " + single_units
						+ " coins of value " + activeCurrency.getUnitValue());

		cs.addCoin(coin, whole_coins);
		cs.addCoin(activeCurrency.getUnitValue(), single_units);
		return cs;
	}

	public SimpleCoinSorter(final Currency currency) {
		super(currency);
	}

}
