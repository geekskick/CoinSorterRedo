package coinSorterRedo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CoinSack {

	private final Map<CoinDenomination, Long> sack = new HashMap<>();
	private final static Logger LOG = Logger.getLogger(CoinSack.class.toString());

	public void addCoin(final CoinDenomination coin, final long whole_coins) {
		LOG.finest(
				"Adding " + whole_coins + " coins of value " + coin.toString());
		sack.put(coin, whole_coins + getQtyForCoin(coin));
		LOG.finest(sack.toString());
	}

	public Map<CoinDenomination, Long> getSack() {
		return sack;
	}

	public Long getQtyForCoin(final CoinDenomination coin) {
		LOG.finest("Coin of value " + coin.toString() + " "
				+ (sack.containsKey(coin) ? "is" : "isn't") + " in sack");
		
		final long qty = sack.containsKey(coin) ? sack.get(coin) : 0;
		return qty;
	}

}
