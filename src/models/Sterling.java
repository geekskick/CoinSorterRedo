package models;

public class Sterling extends Currency {

	public Sterling() {
		super("GBP", new CoinDenomination(1), new CoinDenomination(2),
				new CoinDenomination(5), new CoinDenomination(10),
				new CoinDenomination(20), new CoinDenomination(50),
				new CoinDenomination(100), new CoinDenomination(200));
	}

}
