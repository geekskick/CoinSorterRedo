package creators;

import static org.junit.jupiter.api.Assertions.*;

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
	}

}
