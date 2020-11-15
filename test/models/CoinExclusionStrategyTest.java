package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinExclusionStrategyTest {


	@Test
	void testCalculateSimple200Case() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinExclusionStrategy();

		final CoinSack output = uut.calculate(200, new CoinDenomination(200),
				curr);

		assertEquals(1, output.getSack().keySet().size());
		assertEquals(Long.valueOf(2),
				output.getQtyForCoin(new CoinDenomination(100)));

	}
	
	@Test
	void testCalculateSimple100Case() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinExclusionStrategy();

		final CoinSack output = uut.calculate(300, new CoinDenomination(100),
				curr);

		assertEquals(2, output.getSack().keySet().size());
		assertEquals(Long.valueOf(2),
				output.getQtyForCoin(new CoinDenomination(50)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(200)));
	}
	
	@Test
	void testCalculateSimple50Case() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinExclusionStrategy();

		final CoinSack output = uut.calculate(350, new CoinDenomination(50),
				curr);

		assertEquals(4, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(100)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(Long.valueOf(2),
				output.getQtyForCoin(new CoinDenomination(20)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(10)));
	}
	
	@Test
	void testCalculateSimple20Case() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinExclusionStrategy();

		final CoinSack output = uut.calculate(370, new CoinDenomination(20),
				curr);

		assertEquals(4, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(100)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(50)));
		assertEquals(Long.valueOf(2),
				output.getQtyForCoin(new CoinDenomination(10)));
	}
	
	@Test
	void testCalculateSimple10Case() {
		final Currency curr = new Sterling();
		final SortingStrategy uut = new CoinExclusionStrategy();

		final CoinSack output = uut.calculate(310, new CoinDenomination(10),
				curr);

		assertEquals(3, output.getSack().keySet().size());
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(100)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(Long.valueOf(2),
				output.getQtyForCoin(new CoinDenomination(5)));
	}
	
	@Test
	void testName() {
		assertEquals("Exclusion", new CoinExclusionStrategy().toString());
	}
}
