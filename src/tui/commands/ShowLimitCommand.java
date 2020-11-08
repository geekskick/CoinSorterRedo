package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;

public class ShowLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		final String lls = ((Integer)coinsorter.getLowerLimit()).toString();
		final String uls = ((Integer)coinsorter.getUpperLimit()).toString();
		
		System.out.println("Limits of the coin sorter are " + lls + " up to " + uls);
	}

}
