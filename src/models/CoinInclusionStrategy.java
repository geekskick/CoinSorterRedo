package models;

import org.apache.logging.log4j.LogManager;

public final class CoinInclusionStrategy implements SortingStrategy {

	@Override
	public CoinSack calculate(final int pennies, final CoinDenomination coin,
			final Currency currency) {
		final int whole_coins = pennies / coin.getValue();

		// Banks always win!
		final int single_units = (pennies % coin.getValue())
				/ currency.getUnitValue().getValue();
		final CoinSack cs = new CoinSack();

		LogManager.getRootLogger().trace(pennies + " splits into " + whole_coins
				+ " coins of value " + coin + ". With a remainder of "
				+ single_units + " coins of value " + currency.getUnitValue());

		cs.addCoin(coin, whole_coins);
		if (single_units > 0) {
			cs.addCoin(currency.getUnitValue(), single_units);
		}
		return cs;
	}

	@Override
	public String toString() {
		return "Inclusion";
	}

}
