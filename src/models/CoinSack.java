package models;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.*;

public class CoinSack {

	private final Map<CoinDenomination, Long> sack = new HashMap<>();
	private final static Logger LOG = LogManager.getRootLogger();

	public void addCoin(final CoinDenomination coin, final long whole_coins) {
		LOG.trace(
				"Adding " + whole_coins + " coins of value " + coin.toString());
		sack.put(coin, whole_coins + getQtyForCoin(coin));
		LOG.trace(sack.toString());
	}

	public Map<CoinDenomination, Long> getSack() {
		return sack;
	}

	public Long getQtyForCoin(final CoinDenomination coin) {
		LOG.trace("Coin of value " + coin.toString() + " "
				+ (sack.containsKey(coin) ? "is" : "isn't") + " in sack");
		
		final long qty = sack.containsKey(coin) ? sack.get(coin) : 0;
		return qty;
	}

}
