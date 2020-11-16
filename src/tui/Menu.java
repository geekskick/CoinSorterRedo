package tui;

import tui.commands.Command;

public class Menu {

	public Command getCommand(final MenuChoice[] options) {
		System.out.println("-----------------------");
		System.out.println(name);
		System.out.println("-----------------------");

		for (int i = 1; i <= options.length; ++i) {
			System.out.println(((Integer) i).toString() + ": "
					+ options[i - 1].getName().toUpperCase());
		}
		
		final int choice = UserInput.promptForInt("Select an option:");
		if (choice < 1 || choice > options.length) {
			System.out.println("Outside of range of options");
			return getCommand(options);
		}
		return options[choice - 1].getAction();
	}

	private final String name;

	public Menu(String menu_name) {
		name = menu_name;
	}

}
