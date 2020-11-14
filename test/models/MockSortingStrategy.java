package models;

public class MockSortingStrategy implements SortingStrategy {

	@Override
	public CoinSack calculate(int pennies, CoinDenomination coin,
			Currency currency) {
		return new CoinSack();
	}

}
