package models;

import org.apache.logging.log4j.LogManager;

import exceptions.OutOfRangeException;

public class Limits {
	private int inclusiveUpper;
	private int inclusiveLower;

	Limits(final int iLower, final int iUpper) throws OutOfRangeException {
		inclusiveLower = iLower;
		setInclusiveUpper(iUpper);
		setInclusiveLower(iLower);
	}

	public int getInclusiveUpper() {
		return inclusiveUpper;
	}

	public void setInclusiveUpper(final int inclusiveUpper)
			throws OutOfRangeException {

		if (inclusiveUpper <= 0 || inclusiveUpper < inclusiveLower) {
			LogManager.getRootLogger()
					.trace("Failed to set upper limit to " + inclusiveUpper);
			throw new OutOfRangeException();
		}
		this.inclusiveUpper = inclusiveUpper;
	}

	public int getInclusiveLower() {
		return inclusiveLower;
	}

	public void setInclusiveLower(final int inclusiveLower)
			throws OutOfRangeException {
		
		if (inclusiveLower <= 0 || inclusiveLower > inclusiveUpper) {
			LogManager.getRootLogger()
					.trace("Failed to set lower limit to " + inclusiveUpper);
			throw new OutOfRangeException();
		}
		this.inclusiveLower = inclusiveLower;
	}

	public boolean inRange(final int candidate) {
		return candidate >= inclusiveLower && candidate <= inclusiveUpper;
	}

	@Override
	public String toString() {
		return "[" + inclusiveLower + ", " + inclusiveUpper + "]";
	}

}
