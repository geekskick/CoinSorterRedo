package controller;

import controller.commands.Command;
import view.NewLineOutput;
import view.UserInput;
import view.UserOutputDecoratorBold;
import view.UserOutputDecoratorBrightWhite;
import view.UserOutputDecoratorFailure;

public class Menu {

	public Command getCommand(final MenuChoice[] options) {
		new UserOutputDecoratorBold(NewLineOutput.INSTANCE)
				.show("-----------------------");
		new UserOutputDecoratorBrightWhite(NewLineOutput.INSTANCE).show(name);
		new UserOutputDecoratorBold(NewLineOutput.INSTANCE)
				.show("-----------------------");

		for (int i = 1; i <= options.length; ++i) {
			NewLineOutput.INSTANCE
					.show(i + ": " + options[i - 1].getName().toUpperCase());
		}

		final int choice = UserInput.promptForInt("Select an option:");
		if (choice < 1 || choice > options.length) {
			new UserOutputDecoratorFailure(NewLineOutput.INSTANCE)
					.show("Outside of range of options");
			return getCommand(options);
		}
		return options[choice - 1].getAction();
	}

	private final String name;

	public Menu(String menu_name) {
		name = menu_name;
	}

}
