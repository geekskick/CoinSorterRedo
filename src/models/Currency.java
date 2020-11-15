package models;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Currency {

	@Override
	public String toString() {
		String rc = new String();
		rc += getCode() + ", with denominations: ";
		rc += denominations.stream().map(CoinDenomination::toString)
				.collect(Collectors.joining(", "));
		return rc;
	}

	public CoinDenomination getUnitValue() {
		return denominations.stream()
				.min(Comparator.comparing(CoinDenomination::getValue))
				.orElseThrow();
	}

	public List<CoinDenomination> getCoinDenominations() {
		return denominations;
	}

	public Boolean isValidCoinValue(int value) {
		return denominations.stream().anyMatch(x -> x.getValue() == value);
	}

	public Boolean isValidCoin(CoinDenomination coin) {
		return denominations.stream().anyMatch(x -> x.equals(coin));
	}

	public String getCode() {
		return code;
	}

	protected String code;

	protected List<CoinDenomination> denominations;

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		} else if (other == null) {
			return false;
		} else if (getClass() != other.getClass()) {
			return false;
		} else {
			Currency other_currency = (Currency) other;
			return denominations.equals(other_currency.getCoinDenominations());
		}
	}

	protected Currency(String code, CoinDenomination... denoms) {
		this.denominations = Arrays.asList(denoms);
		this.code = code;
	}

}
