package coinSorterRedo;

import java.util.logging.Logger;

public class SimpleCoinSorter implements CoinSorter {

	@Override
	public Currency getCurrency() {
		return activeCurrency;
	}

	@Override
	public void setCurrency(Currency currency) {
		activeCurrency = currency;
	}

	@Override
	public CoinSack calculate(final long pennies, final CoinDenomination coin)
			throws CurrencyException {
		if (!activeCurrency.isValidCoin(coin)) {
			throw new CurrencyException(
					coin.toString() + " is not a valid coin value in "
							+ activeCurrency.toString());
		}

		final long whole_coins = pennies / coin.getValue();
		final long single_units = (pennies % coin.getValue())
				/ activeCurrency.getUnitValue().getValue();
		final CoinSack cs = new CoinSack();

		Logger.getLogger(getClass().getSimpleName())
				.finest(((Long)pennies).toString() + " splits into " + whole_coins
						+ " coins of value " + coin.toString()
						+ ". With a remainder of " + single_units
						+ " coins of value " + activeCurrency.getUnitValue());

		cs.addCoin(coin, whole_coins);
		cs.addCoin(activeCurrency.getUnitValue(), single_units);
		return cs;
	}

	SimpleCoinSorter(final Currency currency) {
		activeCurrency = currency;
	}

	private Currency activeCurrency;

}
