package tui;

import tui.commands.Command;
import tui.commands.QuitCommand;

public class MenuChoice {
	public String getName() {
		return name;
	}

	public Command getAction() {
		return action;
	}

	public static final MenuChoice QUIT = new MenuChoice("quit", new QuitCommand());

	private final String name;
	private final Command action;

	public MenuChoice(String name, Command action) {
		this.name = name;
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuChoice other = (MenuChoice) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
