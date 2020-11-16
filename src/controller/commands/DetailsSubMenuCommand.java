package controller.commands;

import controller.Menu;
import controller.MenuChoice;
import exceptions.EndAppException;
import models.CoinSorter;

public class DetailsSubMenuCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {

		MenuChoice details_submenu[] = new MenuChoice[] {
				new MenuChoice("show currency", new ShowCurrencyCommand()),
				new MenuChoice("show limits", new ShowLimitCommand()),
				MenuChoice.BACK };

		final Menu menu = new Menu("Details Submenu");

		try {
			while (true) {
				menu.getCommand(details_submenu).perform(coinsorter);
			}
		} catch (EndAppException e) {

		}

	}

}
