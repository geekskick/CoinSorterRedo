package controller.commands;

import exceptions.EndAppException;
import models.CoinSorter;
import view.NewLineOutput;

public class ShowLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		NewLineOutput.INSTANCE.show(
				"Limits of the coin sorter are " + coinsorter.getLimits());
	}

}
