package tui.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import creators.CurrencyFactory;
import exceptions.EndAppException;
import models.CoinDenomination;
import models.CoinSorter;
import models.Currency;
import tui.UserInput;

public class CurrencyConfigurationCommand implements Command {

	private String getNewCurrencyCode() {
		return UserInput
				.promptForString("Enter a currency code for the new currency:");
	}

	private String getNewSuffix() {
		return UserInput.promptForString(
				"Enter a suffix for the currency of the new currency:");
	}

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		final String code = getNewCurrencyCode();
		final String suffix = getNewSuffix();

		// Don't want the same denomination added twice to the currency
		Set<CoinDenomination> newDenoms = new HashSet<CoinDenomination>();

		while (true) {
			final int choice = UserInput
					.promptForInt("Enter a new denomination (0 to finish)");

			if (choice == 0) {
				break;
			}

			newDenoms.add(new CoinDenomination(choice));
		}

		Currency c = new Currency(code, suffix,
				newDenoms.toArray(new CoinDenomination[newDenoms.size()]));

		CurrencyFactory.addCurrency(code, c);

		System.out.println(
				"Added new currency " + code + " to the available currencies");

	}
}
