package models;

public interface SortingStrategy {

	CoinSack calculate(int pennies, CoinDenomination coin, Currency currency);
}
