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
				.promptForInt("Enter the value of the coins you have (in "
						+ coinsorter.getCurrency().getUnitSuffix() + "):");

		String coinPrompt = "Select a coin to sort with using the "
				+ coinsorter.getSortingStrategy().toString().toLowerCase()
				+ " strategy (without the currency suffix):";
		for (CoinDenomination coin : coinsorter.getCurrency()
				.getCoinDenominations()) {
			coinPrompt += "\n\t- " + coin.toString()
					+ coinsorter.getCurrency().getUnitSuffix();

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

		System.out.print("There are ");
		final Map<CoinDenomination, Integer> sackmap = result.getSack();
		for (Map.Entry<CoinDenomination, Integer> result_coin : sackmap
				.entrySet()) {
			System.out.print(result_coin.getValue() + " x "
					+ result_coin.getKey()
					+ coinsorter.getCurrency().getUnitSuffix() + " coins, ");
		}
		System.out.println("and no remainder");

	}

}
