package models;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public abstract class Currency {

	@Override
	public String toString() {
		String rc = new String();
		rc += getCode() + ", with denominations: ";
		rc += Arrays.stream(denominations).map(CoinDenomination::toString).collect(Collectors.joining(", "));
		return rc;
	}
	
	public CoinDenomination getUnitValue() {
		return Arrays.stream(denominations).min(Comparator.comparing(CoinDenomination::getValue)).orElseThrow();
	}

	public CoinDenomination[] getCoinDenominations() {
		return denominations;
	}

	public Boolean isValidCoinValue(int value) {
		return Arrays.stream(denominations).anyMatch(x -> x.getValue() == value);
	}

	public Boolean isValidCoin(CoinDenomination coin) {
		return Arrays.stream(denominations).anyMatch(x -> x.equals(coin));
	}

	public String getCode() {
		return code;
	}

	protected String code;

	protected CoinDenomination denominations[];

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		} else if (other == null) {
			return false;
		} else if (getClass() != other.getClass()) {
			return false;
		} else {
			Currency other_currency = (Currency)other;
			return Arrays.equals(other_currency.getCoinDenominations(),
					denominations);
		}
	}
	
	protected Currency(String code, CoinDenomination ... denoms) {
		this.denominations = denoms;
		this.code = code;
	}
	
}
