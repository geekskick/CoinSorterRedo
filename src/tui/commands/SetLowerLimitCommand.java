package tui.commands;

import java.util.Scanner;

import exceptions.OutOfRangeException;
import models.CoinSorter;
import tui.EndAppException;

public class SetLowerLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.print("Enter a new lower limit\n>\t");
		@SuppressWarnings("resource")
		final Scanner stdin = new Scanner(System.in);
		final int c = stdin.nextInt();
		
		try {
			coinsorter.setLowerLimit(c);
		} catch (OutOfRangeException e) {
			System.out.print("Unable to set lower limit to " + ((Integer)c).toString() + ": ");
			new ShowLimitCommand().perform(coinsorter);
		}

	}

}
