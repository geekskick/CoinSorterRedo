package controller.commands;

import controller.Menu;
import controller.MenuChoice;
import exceptions.EndAppException;
import models.CoinSorter;

public class ConfigurationSubMenuCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		MenuChoice details_submenu[] = new MenuChoice[] {
				new MenuChoice("set lower limit", new SetLowerLimitCommand()),
				new MenuChoice("set upper limit", new SetUpperLimitCommand()),
				new MenuChoice("add currency",
						new CurrencyConfigurationCommand()),
				new MenuChoice("select currency",
						new CurrencySelectionCommand()),
				MenuChoice.BACK };

		final Menu menu = new Menu("Configuration Submenu");

		try {
			while (true) {
				menu.getCommand(details_submenu).perform(coinsorter);
			}
		} catch (EndAppException e) {

		}

	}

}
