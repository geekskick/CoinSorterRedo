package tui.commands;

import exceptions.EndAppException;
import models.CoinInclusionStrategy;
import models.CoinSorter;

public class InclusiveSortCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.print("Enter the value of the coins you have:\n>\t");
		coinsorter.setSortingStrategy(new CoinInclusionStrategy());
		new SortCommand().perform(coinsorter);
	}

}
