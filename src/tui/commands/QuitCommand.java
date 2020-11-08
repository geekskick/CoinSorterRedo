package tui.commands;
import models.CoinSorter;
import tui.EndAppException;

public final class QuitCommand implements Command{

	@Override
	public void perform(CoinSorter unused) throws EndAppException {
		throw new EndAppException();
		
	}

}
