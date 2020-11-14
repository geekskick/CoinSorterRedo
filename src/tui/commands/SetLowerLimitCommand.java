package tui.commands;

import java.util.Scanner;

import exceptions.EndAppException;
import exceptions.OutOfRangeException;
import models.CoinSorter;

public class SetLowerLimitCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		System.out.print("Enter a new lower limit\n>\t");
		@SuppressWarnings("resource")
		final Scanner stdin = new Scanner(System.in);
		
		final int c;
		try {
			c = stdin.nextInt();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		try {
			coinsorter.setLowerLimit(c);
		} catch (OutOfRangeException e) {
			System.out.print("Unable to set lower limit to " + ((Integer)c).toString() + ": ");
			new ShowLimitCommand().perform(coinsorter);
		}

	}

}
