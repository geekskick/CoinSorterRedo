package tui.commands;

import java.util.Scanner;

import models.CoinSorter;
import tui.EndAppException;

public class SetUpperLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.print("Enter a new upper limit\n>\t");
		@SuppressWarnings("resource")
		final Scanner stdin = new Scanner(System.in);
		final int c = stdin.nextInt();
		coinsorter.setUpperLimit(c);

	}

}
