package tui;

import java.util.Scanner;

public class UserInput {
	// Not sure this is the most Java way of doing this; having a class wich
	// doesn't actually store/use any data?
	// Also does java have templates? It must do because of List<> etc, just not
	// sure how to use these yet
	public static int promptForInt(String message) {

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		Integer candidate = null;

		while (candidate == null) {
			System.out.print(message + "\n>\t");
			if (stdin.hasNextInt()) {
				candidate = stdin.nextInt();
				break;
			} else {
				candidate = null;

				// Just get rid of whats there to stop an endless loop of "not a
				// valid option"
				stdin.next();
				System.out.print("Not a valid option. ");
			}
		}

		return candidate;
	}
}
