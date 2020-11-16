package models;

public class WeirdCurrency extends Currency {

	public WeirdCurrency() {
		super("WEIRD", "p", new CoinDenomination(2), new CoinDenomination(10));
	}

}
