package controller.commands;

import java.util.Set;

import creators.CurrencyFactory;
import exceptions.EndAppException;
import models.CoinSorter;
import view.NewLineOutput;
import view.UserInput;
import view.UserOutputDecoratorFailure;
import view.UserOutputDecoratorSuccess;

public class CurrencySelectionCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		String prompt = "Select the active currency from the following options:";
		final Set<String> currencySet = CurrencyFactory.availableCurrencies();
		final String currencies[] = currencySet
				.toArray(new String[currencySet.size()]);
		for (int i = 1; i <= currencies.length; ++i) {
			prompt += "\n\t" + i + ". " + currencies[i - 1];
		}

		final int choice = UserInput.promptForInt(prompt);
		if (choice < 1 || choice > currencies.length) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE)
					.show("Out of range of the available options");
			return;
		}

		final String code = currencies[choice - 1];
		new UserOutputDecoratorSuccess(NewLineOutput.INSTANCE).show(
				"Setting " + code + " to be the active currency in the sorter");

		coinsorter.setCurrency(CurrencyFactory.getCurrency(code));

	}

}
