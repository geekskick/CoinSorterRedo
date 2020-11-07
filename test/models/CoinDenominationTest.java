package models;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinDenominationTest {

	@Test
	void testGetValue() {
		final CoinDenomination uut = new CoinDenomination(433);
		assertEquals(433, uut.getValue());
	}

	@Test
	void testToString() {
		final CoinDenomination uut = new CoinDenomination(433);
		assertEquals(uut.toString(), "433");
	}

	@Test
	void testEqualsObject() {
		final CoinDenomination uut = new CoinDenomination(433);
		final CoinDenomination luut = new CoinDenomination(433);
		final CoinDenomination ruut = new CoinDenomination(2);
		assertEquals(uut, luut);
		assertNotEquals(uut, ruut);
	}

}
