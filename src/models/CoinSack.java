package models;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.*;

public class CoinSack {

	private final Map<CoinDenomination, Long> sack = new HashMap<>();
	private final static Logger LOG = LogManager.getRootLogger();

	public void addCoin(final CoinDenomination coin, final long whole_coins) {
		LOG.trace("Adding " + whole_coins + " coins of value " + coin);
		final long toPut = whole_coins + getQtyForCoin(coin);

		if (toPut == 0) {
			LOG.trace("Not putting in a value of 0 for coin " + coin);
			return;
		}

		sack.put(coin, toPut);
		LOG.trace(sack.toString());
	}

	public Map<CoinDenomination, Long> getSack() {
		return sack;
	}

	public Long getQtyForCoin(final CoinDenomination coin) {
		LOG.trace("Coin of value " + coin + " "
				+ (sack.containsKey(coin) ? "is" : "isn't") + " in sack");

		final long qty = sack.containsKey(coin) ? sack.get(coin) : 0;
		return qty;
	}

}
