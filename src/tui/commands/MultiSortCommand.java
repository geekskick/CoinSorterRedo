package tui.commands;

import exceptions.EndAppException;
import models.CoinExclusionStrategy;
import models.CoinSorter;

public class MultiSortCommand extends SortCommand {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		coinsorter.setSortingStrategy(new CoinExclusionStrategy());
		super.perform(coinsorter);
	}

}
