package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;

public class MultiSortCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		coinsorter.setSortingStrategy(new CoinExclusionStrategy());
		new SortCommand().perform(coinsorter);
	}

}
