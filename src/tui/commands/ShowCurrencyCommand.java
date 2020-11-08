package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;

public class ShowCurrencyCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.println("The active currency is " + coinsorter.getCurrency().toString());

	}

}
