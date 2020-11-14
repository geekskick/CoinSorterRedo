package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

class SimpleCoinSorterTest {

	@Test
	void testCalculateInvalidDenomination() {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);
		
		try {
			uut.calculate(1000, new CoinDenomination(3));
			fail("Nothing thrown");
		} catch (InvalidDenominationException e) {
			// do nothing
		} catch (OutOfRangeException e) {
			fail("Wrong exception");
		}
	}

	@Test
	void testCurrencyGet() {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);
		
		assertEquals(new Sterling(), uut.getCurrency());
	}

	@Test
	void testInitialRange() {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);
		
		assertEquals(1, uut.getLowerLimit());
		assertEquals(10000, uut.getUpperLimit());
	}

	@Test
	void testOORCalculation() {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);
		
		try {
			uut.calculate(0, new CoinDenomination(1));
			fail("Expected Exception");
		} catch (OutOfRangeException e) {
		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");
		}
	}

	@Test
	void testLimitSetting() throws OutOfRangeException {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);
		
		uut.setLowerLimit(4);
		assertEquals(4, uut.getLowerLimit());
		uut.setUpperLimit(400);
		assertEquals(400, uut.getUpperLimit());

		try {
			uut.setLowerLimit(400000);
			fail("Expected exception");
		} catch (OutOfRangeException e) {
		}
		try {
			uut.setUpperLimit(1);
			fail("Expected exception");
		} catch (OutOfRangeException e) {

		}
	}

	@Test
	void testLimitCalculation() {
		final Currency gbp = new Sterling();
		final SortingStrategy strat = new MockSortingStrategy();
		final CoinSorter uut = new CoinSorter(gbp, strat);

		try {
			uut.calculate(-1, new CoinDenomination(2));
			fail("Expected exception");
		} catch (OutOfRangeException e) {

		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");
		}
		
		try {
			uut.calculate(0, new CoinDenomination(2));
			fail("Expected exception");
		} catch (OutOfRangeException e) {

		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");	
		}	
		
		try {
			uut.calculate(1, new CoinDenomination(2));
		} catch (OutOfRangeException e) {
			fail("Expected no exception");
		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");
		}
		
		try {
			uut.calculate(10000, new CoinDenomination(2));
		} catch (OutOfRangeException e) {
			fail("Expected no exception");
		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");
		}
		
		try {
			uut.calculate(10001, new CoinDenomination(2));
			fail("Expected exception");
		} catch (OutOfRangeException e) {
		} catch (InvalidDenominationException e) {
			fail("Wrong Exception");
		}
	}

}
