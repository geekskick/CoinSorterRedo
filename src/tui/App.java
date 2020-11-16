package tui;

import org.apache.logging.log4j.LogManager;

import creators.CurrencyFactory;
import exceptions.EndAppException;
import exceptions.OutOfRangeException;
import models.CoinSorter;
import tui.commands.ConfigurationSubMenuCommand;
import tui.commands.DetailsSubMenuCommand;
import tui.commands.InclusiveSortCommand;
import tui.commands.MultiSortCommand;

public class App {

	public static void main(String[] args) throws OutOfRangeException {

		LogManager.getRootLogger().trace("Starting main");

		final CoinSorter sorter = new CoinSorter(
				CurrencyFactory.getCurrency("GBP"), null);

		final Menu menu = new Menu("Main Menu");

		// Not sure this way of exitting the menus is abuse of exceptions
		try {
			while (true) {
				final MenuChoice options[] = {
						new MenuChoice("Coin Sort", new InclusiveSortCommand()),
						new MenuChoice("Multi Coin Sort",
								new MultiSortCommand()),
						new MenuChoice("see details",
								new DetailsSubMenuCommand()),
						new MenuChoice("configure",
								new ConfigurationSubMenuCommand()),
						MenuChoice.QUIT };

				LogManager.getLogger(App.class).trace("Presenting main menu");
				menu.getCommand(options).perform(sorter);
			}
		} catch (EndAppException e) {
			System.out.println("Goodbye");
			// End of app, do nothing
		}

		System.gc();

	}

}
