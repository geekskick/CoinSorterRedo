package coinSorterRedo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinSackTest {

	@Test
	void testSack() {
		final CoinSack uut = new CoinSack();
		assertEquals(uut.getSack().size(), 0);
		
		uut.addCoin(new CoinDenomination(22), 33);
		assertEquals(uut.getSack().size(), 1);
		assertTrue(uut.getSack().containsKey(new CoinDenomination(22)));
		assertEquals(uut.getSack().get(new CoinDenomination(22)), 33);
		
		assertEquals(uut.getQtyForCoin(new CoinDenomination(22)), 33);
		assertEquals(uut.getQtyForCoin(new CoinDenomination(100)), 0);
		
	}


}
