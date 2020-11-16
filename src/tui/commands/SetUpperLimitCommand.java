package tui.commands;

import exceptions.EndAppException;
import exceptions.OutOfRangeException;
import models.CoinSorter;
import tui.UserInput;

public class SetUpperLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		
		final int c = UserInput.promptForInt("Enter a new upper limit");
		
		try {
			coinsorter.getLimits().setInclusiveUpper(c);
		} catch (OutOfRangeException e) {
			System.out.print("Unable to set upper limit to " + ((Integer)c).toString() + ": ");
			new ShowLimitCommand().perform(coinsorter);
		}
	}

}
