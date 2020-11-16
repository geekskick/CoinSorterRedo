package controller.commands;

import exceptions.EndAppException;
import models.CoinSorter;
import view.NewLineOutput;

public class ShowCurrencyCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		NewLineOutput.INSTANCE
				.show("The active currency is " + coinsorter.getCurrency());

	}

}
