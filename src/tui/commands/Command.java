package tui.commands;

import models.CoinSorter;
import tui.EndAppException;

public interface Command{
	public void perform(CoinSorter coinsorter) throws EndAppException;
	
}
