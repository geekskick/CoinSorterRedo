package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import creators.CurrencyFactory;
import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;

class SimpleCoinSorterTest {

	@Test
	void testCalculateSimpleCase()
			throws InvalidDenominationException, OutOfRangeException {
		final CoinSorter uut = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
		final CoinSack output = uut.calculate(1000, new CoinDenomination(200));
		assertEquals(Long.valueOf(5),
				output.getQtyForCoin(new CoinDenomination(200)));

		for (CoinDenomination coin : uut.getCurrency().getCoinDenominations()) {
			if (coin.getValue() != 200) {
				assertEquals(Long.valueOf(0), output.getQtyForCoin(coin));
			}
		}
	}

	@Test
	void testCalculateRemainderCaseSmallestUnit2()
			throws InvalidDenominationException, OutOfRangeException {
		final Currency curr = new WeirdCurrency();
		final CoinSorter uut = new SimpleCoinSorter(curr);
		final CoinSack output = uut.calculate(12, new CoinDenomination(10));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(10)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(2)));
	}

	@Test
	void testCalculateRemainderCaseSmallestUnit2RoundsDown()
			throws InvalidDenominationException, OutOfRangeException {
		final Currency curr = new WeirdCurrency();
		final CoinSorter uut = new SimpleCoinSorter(curr);
		final CoinSack output = uut.calculate(13, new CoinDenomination(10));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(10)));
		assertEquals(Long.valueOf(1),
				output.getQtyForCoin(new CoinDenomination(2)));
	}

	@Test
	void testCalculateRemainderCase()
			throws InvalidDenominationException, OutOfRangeException {
		final CoinSorter uut = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
		final CoinSack output = uut.calculate(1199, new CoinDenomination(200));
		assertEquals(Long.valueOf(5),
				output.getQtyForCoin(new CoinDenomination(200)));
		assertEquals(Long.valueOf(199),
				output.getQtyForCoin(new CoinDenomination(1)));

		for (CoinDenomination coin : uut.getCurrency().getCoinDenominations()) {
			if (coin.getValue() != 200 && coin.getValue() != 1) {
				assertEquals(Long.valueOf(0), output.getQtyForCoin(coin));
			}
		}
	}

	@Test
	void testCalculateInvalidDenomination() {
		final Currency gbp = new Sterling();
		final CoinSorter uut = new SimpleCoinSorter(gbp);
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
		final CoinSorter uut = new SimpleCoinSorter(gbp);
		assertEquals(new Sterling(), uut.getCurrency());
	}

	@Test
	void testInitialRange() {
		final CoinSorter uut = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
		assertEquals(1, uut.getLowerLimit());
		assertEquals(10000, uut.getUpperLimit());
	}

	@Test
	void testOORCalculation() {
		final CoinSorter uut = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
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
		final CoinSorter uut = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
		uut.setLowerLimit(4);
		assertEquals(4, uut.getLowerLimit());
		uut.setUpperLimit(400);
		assertEquals(400, uut.getUpperLimit());

		try {
			uut.setLowerLimit(400000);
			fail("Expected exception");
		} catch (OutOfRangeException e) {

		}
	}

}
