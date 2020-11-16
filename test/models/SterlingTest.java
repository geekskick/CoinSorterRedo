package models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SterlingTest {

	@Test
	void testGetCoinDenominations() {

		final List<CoinDenomination> expected = new ArrayList<CoinDenomination>(Arrays.asList( new CoinDenomination(1),
				new CoinDenomination(2), new CoinDenomination(5),
				new CoinDenomination(10), new CoinDenomination(20),
				new CoinDenomination(50), new CoinDenomination(100),
				new CoinDenomination(200)));
		Sterling uut = new Sterling();
		
		assertTrue(expected.equals(uut.getCoinDenominations()));
	}

	@Test
	void testIsValidCoinValue() {
		final Sterling uut = new Sterling();
		assertTrue(uut.isValidCoinValue(1));
		assertTrue(uut.isValidCoinValue(2));
		assertTrue(uut.isValidCoinValue(5));
		assertTrue(uut.isValidCoinValue(10));
		assertTrue(uut.isValidCoinValue(20));
		assertTrue(uut.isValidCoinValue(50));
		assertTrue(uut.isValidCoinValue(100));
		assertTrue(uut.isValidCoinValue(200));
		assertFalse(uut.isValidCoinValue(0));
		assertFalse(uut.isValidCoinValue(3));
	}

	@Test
	void testIsValidCoin() {
		final CoinDenomination real_values[] = { new CoinDenomination(1),
				new CoinDenomination(2), new CoinDenomination(5),
				new CoinDenomination(10), new CoinDenomination(20),
				new CoinDenomination(50), new CoinDenomination(100),
				new CoinDenomination(200) };
		final Sterling uut = new Sterling();

		for (CoinDenomination coin : real_values) {
			assertTrue(uut.isValidCoin(coin));
		}
	}

	@Test
	void testGetUnitValue() {
		Sterling uut = new Sterling();
		assertEquals(new CoinDenomination(1), uut.getUnitValue());
	}

	@Test
	void testToString() {
		Sterling uut = new Sterling();
		assertEquals("GBP, with denominations: 1, 2, 5, 10, 20, 50, 100, 200",
				uut.toString());
	}

	@Test
	void testEquals() {
		assertEquals(new Sterling(), new Sterling());
	}

	@Test
	void testCode() {
		assertEquals(new Sterling().getCode(), "GBP");
	}
	
	@Test
	void testSuffix() {
		assertEquals(new Sterling().getUnitSuffix(), "p");
	}
}
