package controller;

import controller.commands.Command;
import view.NewLineOutput;
import view.UserInput;
import view.UserOutputDecoratorFailure;

public class Menu {

	public Command getCommand(final MenuChoice[] options) {
		NewLineOutput.INSTANCE.show("-----------------------");
		NewLineOutput.INSTANCE.show(name);
		NewLineOutput.INSTANCE.show("-----------------------");

		for (int i = 1; i <= options.length; ++i) {
			NewLineOutput.INSTANCE.show(i + ": "
					+ options[i - 1].getName().toUpperCase());
		}
		
		final int choice = UserInput.promptForInt("Select an option:");
		if (choice < 1 || choice > options.length) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE).show("Outside of range of options");
			return getCommand(options);
		}
		return options[choice - 1].getAction();
	}

	private final String name;

	public Menu(String menu_name) {
		name = menu_name;
	}

}
