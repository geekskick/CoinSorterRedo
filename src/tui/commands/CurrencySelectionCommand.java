package tui.commands;

import java.util.Set;

import creators.CurrencyFactory;
import exceptions.EndAppException;
import models.CoinSorter;
import tui.UserInput;

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
			System.out.println("Out of range of the available options");
			return;
		}

		final String code = currencies[choice - 1];
		System.out.println(
				"Setting " + code + " to be the active currency in the sorter");
		coinsorter.setCurrency(CurrencyFactory.getCurrency(code));

	}

}
