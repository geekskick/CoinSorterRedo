package models;

public class CoinDenomination {
	
	private final int value;
	public CoinDenomination(final int d){
		value = d;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return ((Integer)value).toString();
	}
	
	@Override
	public boolean equals(final Object other) {
		if(this == other) {
			return true;
		}else if(other == null) {
			return false;
		}else if(getClass() != other.getClass()) {
			return false;
		}else {
			CoinDenomination other_coin = (CoinDenomination)other;
			return other_coin.getValue() == value;
		}
	}
	
	@Override
	public int hashCode() {
		return value;
	}
	
}
