package controller.commands;

import exceptions.EndAppException;
import models.CoinInclusionStrategy;
import models.CoinSorter;

public class InclusiveSortCommand extends SortCommand {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		coinsorter.setSortingStrategy(new CoinInclusionStrategy());
		super.perform(coinsorter);
	}

}
