package models;

import java.util.Arrays;

public class Sterling implements Currency {

	private static final CoinDenomination COIN_VALUES[] = {
			new CoinDenomination(1), new CoinDenomination(2),
			new CoinDenomination(5), new CoinDenomination(10),
			new CoinDenomination(20), new CoinDenomination(50),
			new CoinDenomination(100), new CoinDenomination(200) };

	@Override
	public CoinDenomination[] getCoinDenominations() {
		return COIN_VALUES;
	}

	@Override
	public Boolean isValidCoinValue(int value) {
		return Arrays.stream(COIN_VALUES).anyMatch(x -> x.getValue() == value);
	}

	@Override
	public Boolean isValidCoin(CoinDenomination coin) {
		return Arrays.stream(COIN_VALUES).anyMatch(x -> x.equals(coin));
	}

	@Override
	public CoinDenomination getUnitValue() {
		return new CoinDenomination(1);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		} else if (other == null) {
			return false;
		} else if (getClass() != other.getClass()) {
			return false;
		} else {
			Sterling other_currency = (Sterling) other;
			return Arrays.equals(other_currency.getCoinDenominations(),
					COIN_VALUES);
		}
	}
}
