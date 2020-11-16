package tui.commands;

import exceptions.EndAppException;
import exceptions.OutOfRangeException;
import models.CoinSorter;
import tui.UserInput;

public class SetLowerLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		
		final int c = UserInput.promptForInt("Enter a new lower limit");
		
		try {
			coinsorter.getLimits().setInclusiveLower(c);
		} catch (OutOfRangeException e) {
			System.out.print("Unable to set lower limit to " + ((Integer)c).toString() + ": ");
			new ShowLimitCommand().perform(coinsorter);
		}

	}

}
