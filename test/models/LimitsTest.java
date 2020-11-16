package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.OutOfRangeException;

class LimitsTest {

	@Test
	void testGetters() throws OutOfRangeException {
		Limits uut = new Limits(1, 10);
		assertEquals(1, uut.getInclusiveLower());
		assertEquals(10, uut.getInclusiveUpper());

		uut = new Limits(1, 1);
		// Jus don't expect a throw
	}

	@SuppressWarnings("unused")
	@Test
	void testOORCtor() {
		try {
			final Limits uut = new Limits(0, 10);
			fail("Expected an exception");
		} catch (OutOfRangeException e) {

		}

		try {
			final Limits uut = new Limits(2, 1);
			fail("Expected an exception");
		} catch (OutOfRangeException e) {

		}
	}

	@Test
	void testSetUpper() throws OutOfRangeException {
		final Limits uut = new Limits(5, 10);
		// Just dont expect a throw
		uut.setInclusiveUpper(5);

		try {
			uut.setInclusiveUpper(4);
			fail("Expected a throw");
		} catch (OutOfRangeException e) {
			assertEquals(5, uut.getInclusiveLower());
			assertEquals(5, uut.getInclusiveUpper());

		}
	}

	@Test
	void testSetLower() throws OutOfRangeException {
		final Limits uut = new Limits(5, 10);
		// Just dont expect a throw
		uut.setInclusiveLower(10);

		try {
			uut.setInclusiveLower(11);
			fail("Expected a throw");
		} catch (OutOfRangeException e) {
			assertEquals(10, uut.getInclusiveLower());
			assertEquals(10, uut.getInclusiveUpper());
		}
		
		try {
			uut.setInclusiveLower(0);
			fail("Expected a throw");
		} catch (OutOfRangeException e) {
			assertEquals(10, uut.getInclusiveLower());
			assertEquals(10, uut.getInclusiveUpper());
		}
	}

	@Test
	void testSetRangeCheck() throws OutOfRangeException {
		final Limits uut = new Limits(5, 10);
		
		assertFalse(uut.inRange(4));
		
		for (int i = 5; i <= 10; ++i) {
			assertTrue(uut.inRange(i));
		}
		
		assertFalse(uut.inRange(11));
	}
	
	@Test
	void testString() throws OutOfRangeException {
		final Limits uut = new Limits(1,1000);
		assertEquals(uut.toString(), "[1, 1000]");
	}
}
