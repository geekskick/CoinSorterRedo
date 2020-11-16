package controller.commands;
import exceptions.EndAppException;
import models.CoinSorter;

public final class QuitCommand implements Command{

	@Override
	public void perform(CoinSorter unused) throws EndAppException {
		throw new EndAppException();
		
	}

}
