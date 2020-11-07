package coinSorterRedo;

public interface CoinSorter {
	Currency getCurrency();
	void setCurrency(final Currency currency);
	CoinSack calculate(final long pennies, final CoinDenomination coin_denomination) throws CurrencyException;
	
}
