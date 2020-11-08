package tui;

import java.util.InputMismatchException;
import java.util.Scanner;

import tui.commands.Command;

public class Menu {

	public Command getCommand(final MenuChoice[] options) {
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println(name);
		System.out.println("-----------------------");

		for (int i = 1; i <= options.length; ++i) {
			System.out.println(((Integer) i).toString() + ": "
					+ options[i - 1].getName().toUpperCase());
		}
		try {
			final int choice = stdin.nextInt();
			if (choice < 1 || choice > options.length) {
				System.out.println("Outside of range of options");
				return getCommand(options);
			}
			return options[choice - 1].getAction();
		} catch (InputMismatchException ime) {
			System.out.println("Cannot convert that choice to an option");
			return getCommand(options);
		}
	}

	private final String name;

	public Menu(String menu_name) {
		name = menu_name;
	}

}
