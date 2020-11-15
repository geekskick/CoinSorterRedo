package models;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;

public class CoinExclusionStrategy implements SortingStrategy {

	@Override
	public CoinSack calculate(int pennies, CoinDenomination coin,
			Currency currency) {

		final CoinSack cs = new CoinSack();
		final List<CoinDenomination> descendingCoins = currency
				.getCoinDenominations();
		Collections.sort(descendingCoins);

		for (CoinDenomination denom : descendingCoins) {
			if (pennies == 0) {
				break;
			}

			if (denom.equals(coin)) {
				LogManager.getRootLogger().trace("Ignoring coin: " + coin);
				continue;
			}

			final int wholes = pennies / denom.getValue();

			LogManager.getRootLogger().trace(pennies + " splits into " + wholes
					+ " coins of value " + denom);
			pennies %= denom.getValue();

			cs.addCoin(denom, wholes);
		}

		return cs;
	}

	@Override
	public String toString() {
		return "Exclusion";
	}
}
