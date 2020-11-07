package coinSorterRedo;

public interface Currency {
	CoinDenomination[] getCoinDenominations();
	Boolean isValidCoinValue(final int value);
	Boolean isValidCoin(final CoinDenomination coin);
	CoinDenomination getUnitValue();
}
