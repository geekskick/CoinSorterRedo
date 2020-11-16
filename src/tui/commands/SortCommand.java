package tui.commands;

import java.util.Map;
import exceptions.EndAppException;
import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;
import models.CoinDenomination;
import models.CoinSack;
import models.CoinSorter;
import tui.UserInput;

public class SortCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {

		final int value = UserInput
				.promptForInt("Enter the value of the coins you have:");

		String coinPrompt = "Select a coin to sort with using the "
				+ coinsorter.getSortingStrategy().toString().toLowerCase()
				+ " strategy:";
		for (CoinDenomination coin : coinsorter.getCurrency()
				.getCoinDenominations()) {
			coinPrompt += "\n\t- " + coin.toString();

		}

		final int coin = UserInput.promptForInt(coinPrompt);
		final CoinSack result;

		try {
			result = coinsorter.calculate(value, new CoinDenomination(coin));
		} catch (InvalidDenominationException e) {
			System.err.println(
					"Must enter a valid denomination, " + coin + " isn't one");
			return;
		} catch (OutOfRangeException e) {
			System.err.println("Must enter a value in the range "
					+ coinsorter.getLimits());
			return;
		}

		final Map<CoinDenomination, Integer> sackmap = result.getSack();
		for (Map.Entry<CoinDenomination, Integer> result_coin : sackmap
				.entrySet()) {
			System.out.println("There are " + result_coin.getValue()
					+ " coins of value " + result_coin.getKey());
		}

	}

}
