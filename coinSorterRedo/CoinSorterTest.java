package coinSorterRedo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleCoinSorterTest {

	@Test
	void testCalculateSimpleCase() throws CurrencyException {
		final Currency gbp = new Sterling();
		final CoinSorter uut = new SimpleCoinSorter(gbp);
		final CoinSack output = uut.calculate(1000, new CoinDenomination(200));
		assertEquals(5, output.getQtyForCoin(new CoinDenomination(200)));

		for (CoinDenomination coin : gbp.getCoinDenominations()) {
			if (coin.getValue() != 200) {
				assertEquals(0, output.getQtyForCoin(coin));
			}
		}
	}

	@Test
	void testCalculateRemainderCase() throws CurrencyException {
		final Currency gbp = new Sterling();
		final CoinSorter uut = new SimpleCoinSorter(gbp);
		final CoinSack output = uut.calculate(1199, new CoinDenomination(200));
		assertEquals(5, output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(199, output.getQtyForCoin(new CoinDenomination(1)));

		for (CoinDenomination coin : gbp.getCoinDenominations()) {
			if (coin.getValue() != 200 && coin.getValue() != 1) {
				assertEquals(0, output.getQtyForCoin(coin));
			}
		}
	}

	@Test
	void testCalculateInvalidDenomination() throws CurrencyException {
		final Currency gbp = new Sterling();
		final CoinSorter uut = new SimpleCoinSorter(gbp);
		try {
			uut.calculate(1000, new CoinDenomination(3));
			fail("Nothing thrown");
		} catch (CurrencyException e) {
			// do nothing
		}
	}
	
	@Test
	void testCurrencyGet() {
		final Currency gbp = new Sterling();
		final CoinSorter uut = new SimpleCoinSorter(gbp);
		assertEquals(new Sterling(), uut.getCurrency());
	}
}
