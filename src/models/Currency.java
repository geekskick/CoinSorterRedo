package models;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Currency {

	@Override
	public String toString() {
		String rc = new String();
		rc += getCode() + ", with denominations: ";
		rc += denominations.stream().map(CoinDenomination::toString)
				.collect(Collectors.joining(getUnitSuffix() + ", "));
		rc += getUnitSuffix();
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

	public String getUnitSuffix() {
		return uSuffix;
	}

	protected String code;
	protected String uSuffix;
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

	public Currency(String code, String uSuffix,
			CoinDenomination... denoms) {
		this.denominations = Arrays.asList(denoms);
		this.code = code;
		this.uSuffix = uSuffix;
	}

}
