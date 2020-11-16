package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;

public class ShowLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.println("Limits of the coin sorter are " + coinsorter.getLimits());
	}

}
