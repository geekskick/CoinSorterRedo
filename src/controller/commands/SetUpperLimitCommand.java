package controller.commands;

import exceptions.EndAppException;
import exceptions.OutOfRangeException;
import models.CoinSorter;
import view.NewLineOutput;
import view.UserInput;
import view.UserOutputDecoratorFailure;

public class SetUpperLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {

		final int c = UserInput.promptForInt("Enter a new upper limit");

		try {
			coinsorter.getLimits().setInclusiveUpper(c);
		} catch (OutOfRangeException e) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE)
					.show("Unable to set upper limit to "
							+ ((Integer) c).toString() + ": ");
			new ShowLimitCommand().perform(coinsorter);
		}
	}

}
