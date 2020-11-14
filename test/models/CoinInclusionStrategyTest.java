package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinInclusionStrategyTest {

	@Test
	void testCalculateRemainderCaseSmallestUnit2() {
		final Currency curr = new WeirdCurrency();
		final SortingStrategy uut = new CoinInclusionStrategy();

		final CoinSack output = uut.calculate(12, new CoinDenomination(10),
				curr);

		assertEquals(2, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(10)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(2)));
	}

	@Test
	void testCalculateRemainderCaseSmallestUnit2RoundsDown() {
		final Currency curr = new WeirdCurrency();
		final SortingStrategy uut = new CoinInclusionStrategy();

		final CoinSack output = uut.calculate(13, new CoinDenomination(10),
				curr);

		assertEquals(2, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(10)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(2)));
	}

	@Test
	void testCalculateRemainderCase() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinInclusionStrategy();

		final CoinSack output = uut.calculate(1199, new CoinDenomination(200),
				curr);

		assertEquals(2, output.getSack().keySet().size());
		assertEquals(Long.valueOf(5),
				output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(Long.valueOf(199),
				output.getQtyForCoin(new CoinDenomination(1)));

	}

	@Test
	void testCalculateSimpleCase() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinInclusionStrategy();

		final CoinSack output = uut.calculate(200, new CoinDenomination(200),
				curr);

		assertEquals(1, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(200)));

	}
	
	@Test
	void testName() {
		assertEquals("Inclusion", new CoinInclusionStrategy().toString());
	}
}
