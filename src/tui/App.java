package tui;

import org.apache.logging.log4j.LogManager;

import creators.CurrencyFactory;
import exceptions.EndAppException;
import models.CoinSorter;
import models.CoinInclusionStrategy;
import tui.commands.ConfigurationSubMenuCommand;
import tui.commands.DetailsSubMenuCommand;
import tui.commands.SortCoinsCommand;

public class App {

	public static void main(String[] args) {

		LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).trace("Starting main");
		
		final CoinSorter sorter = new CoinSorter(
				CurrencyFactory.getCurrency("GBP"),
				new CoinInclusionStrategy());
		final Menu menu = new Menu("Main Menu");

		try {
			while (true) {
				final MenuChoice options[] = {
						new MenuChoice("Coin Sort", new SortCoinsCommand()),
						new MenuChoice("see details",
								new DetailsSubMenuCommand()),
						new MenuChoice("configure",
								new ConfigurationSubMenuCommand()),
						MenuChoice.QUIT };
				
				LogManager.getLogger(App.class).trace("Presenting main menu");
				menu.getCommand(options).perform(sorter);
			}
		} catch (EndAppException e) {
			// End of app, do nothing
		}

	}

}
