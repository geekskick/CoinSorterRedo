package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;

public interface Command{
	public void perform(CoinSorter coinsorter) throws EndAppException;
	
}
