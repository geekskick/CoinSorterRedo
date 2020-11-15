package tui.commands;

import java.util.Map;
import java.util.Scanner;

import exceptions.EndAppException;
import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;
import models.CoinDenomination;
import models.CoinSack;
import models.CoinSorter;

public class SortCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {

		System.out.print("Enter the value of the coins you have:\n>\t");
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		final int value = stdin.nextInt();

		System.out.println("Select a coin to sort with using the "
				+ coinsorter.getSortingStrategy().toString().toLowerCase()
				+ " strategy:");
		for (CoinDenomination coin : coinsorter.getCurrency()
				.getCoinDenominations()) {
			System.out.println("- " + coin.toString());

		}

		final int coin = stdin.nextInt();
		final CoinSack result;

		try {
			result = coinsorter.calculate(value, new CoinDenomination(coin));
		} catch (InvalidDenominationException e) {
			System.err.println(
					"Must enter a valid denomination, " + coin + " isn't one");
			return;
		} catch (OutOfRangeException e) {
			System.err.println("Must enter a value in the range "
					+ coinsorter.getLowerLimit() + " up to "
					+ coinsorter.getUpperLimit());
			return;
		}

		final Map<CoinDenomination, Long> sackmap = result.getSack();
		for (Map.Entry<CoinDenomination, Long> result_coin : sackmap
				.entrySet()) {
			System.out.println("There are " + result_coin.getValue()
					+ " coins of value " + result_coin.getKey());
		}

	}

}