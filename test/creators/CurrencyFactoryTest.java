package creators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import models.Sterling;
import models.WeirdCurrency;

class CurrencyFactoryTest {

	@Test
	void testGetCurrency() {
		assertEquals(CurrencyFactory.getCurrency("GBP"), new Sterling());
	}

	@Test
	void testAddCurrency() {
		{
			CurrencyFactory.addCurrency(new WeirdCurrency().getCode(),
					new WeirdCurrency());
		}
		{
			assertEquals(
					CurrencyFactory.getCurrency(new WeirdCurrency().getCode()),
					new WeirdCurrency());
		}
		{
			final Set<String> expected = new HashSet<String>();
			expected.add("GBP");
			expected.add(new WeirdCurrency().getCode());
			assertEquals(expected, CurrencyFactory.availableCurrencies());
		}
	}

}
