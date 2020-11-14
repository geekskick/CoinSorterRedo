package tui.commands;

import java.util.Map;
import java.util.Scanner;

import exceptions.EndAppException;
import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;
import models.CoinDenomination;
import models.CoinInclusionStrategy;
import models.CoinSack;
import models.CoinSorter;

public class InclusiveSortCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.print("Enter the value of the coins you have:\n>\t");
		coinsorter.setSortingStrategy(new CoinInclusionStrategy());
		
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		final int value = stdin.nextInt();

		System.out.println("Select a coin to sort to:");
		for (CoinDenomination coin : coinsorter.getCurrency()
				.getCoinDenominations()) {
			System.out.println("- " + coin.toString());

		}

		final int coin = stdin.nextInt();
		final CoinSack result;

		try {
			result = coinsorter.calculate(value, new CoinDenomination(coin));
		} catch (InvalidDenominationException e) {
			System.err.println("Must enter a valid denomination, "
					+ ((Integer) coin).toString() + " isn't one");
			return;
		} catch (OutOfRangeException e) {
			System.err.println("Must enter a value in the range "
					+ ((Integer) coinsorter.getLowerLimit()).toString()
					+ " up to "
					+ ((Integer) coinsorter.getUpperLimit()).toString());
			return;
		}

		final Map<CoinDenomination, Long> sackmap = result.getSack();
		for (Map.Entry<CoinDenomination, Long> result_coin : sackmap
				.entrySet()) {
			System.out.println("There are " + result_coin.getValue().toString()
					+ " coins of value " + result_coin.getKey().toString());
		}

	}

}
