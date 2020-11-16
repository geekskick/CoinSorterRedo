package controller.commands;

import java.util.Map;
import exceptions.EndAppException;
import exceptions.InvalidDenominationException;
import exceptions.OutOfRangeException;
import models.CoinDenomination;
import models.CoinSack;
import models.CoinSorter;
import view.NewLineOutput;
import view.UserInput;
import view.UserOutputDecoratorFailure;
import view.UserOutputDecoratorSuccess;

public class SortCommand implements Command {

	private String getPrompt(final CoinSorter coinsorter) {

		String coinPrompt = "Select a coin to sort with using the "
				+ coinsorter.getSortingStrategy().toString().toLowerCase()
				+ " strategy (without the currency suffix "
				+ coinsorter.getCurrency().getUnitSuffix() + "):";
		for (CoinDenomination coin : coinsorter.getCurrency()
				.getCoinDenominations()) {
			coinPrompt += "\n\t- " + coin.toString()
					+ coinsorter.getCurrency().getUnitSuffix();
		}
		return coinPrompt;
	}

	private String createResultString(final CoinSorter coinsorter,
			final Map<CoinDenomination, Integer> sackmap) {
		String rc = "There are ";
		for (Map.Entry<CoinDenomination, Integer> result_coin : sackmap
				.entrySet()) {
			rc += result_coin.getValue() + " x " + result_coin.getKey()
					+ coinsorter.getCurrency().getUnitSuffix() + " coins, ";
		}
		rc += "and no remainder";
		return rc;
	}

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {

		final int value = UserInput
				.promptForInt("Enter the value of the coins you have (in "
						+ coinsorter.getCurrency().getUnitSuffix() + "):");

		final int coin = UserInput.promptForInt(getPrompt(coinsorter));
		final CoinSack result;

		try {
			result = coinsorter.calculate(value, new CoinDenomination(coin));
		} catch (InvalidDenominationException e) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE).show(
					"Must enter a valid denomination, " + coin + " isn't one");
			return;
		} catch (OutOfRangeException e) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE)
					.show("Must enter a value in the range "
							+ coinsorter.getLimits());
			return;
		}

		new UserOutputDecoratorSuccess(NewLineOutput.INSTANCE)
				.show(createResultString(coinsorter, result.getSack()));

	}

}
