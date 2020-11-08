package models;

import java.util.Arrays;

public class WeirdCurrency implements Currency {

	final static CoinDenomination COIN_VALUES[] = {
			new CoinDenomination(2),
			new CoinDenomination(10)
	};
	
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
		return new CoinDenomination(2);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
