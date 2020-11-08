package tui;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import creators.CurrencyFactory;
import models.CoinSorter;
import models.SimpleCoinSorter;
import tui.commands.ConfigurationSubMenuCommand;
import tui.commands.DetailsSubMenuCommand;
import tui.commands.SortCoinsCommand;

public class App {

	public static void main(String[] args) {
		final Options opt = new Options();
		opt.addOption("h", "help", false, "Show this message");
		opt.addOption("v", "verbose", false, "Verbose Logging");

		final CommandLineParser clip = new DefaultParser();
		final CommandLine cl;

		try {
			cl = clip.parse(opt, args);
		} catch (ParseException p) {
			System.err.println(p.getMessage());
			return;
		}

		if (cl.hasOption("h")) {
			final HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("CoinSorterRedo", opt);
			return;
		}

		if (cl.hasOption("v")) {
			// Doesn't work?
			// FIXME
			Logger.getGlobal().setLevel(Level.ALL);
			Logger.getGlobal().finest("Verbose logging enabled");
		}

		final CoinSorter sorter = new SimpleCoinSorter(
				CurrencyFactory.getCurrency("GBP"));
		final Menu menu = new Menu("Main Menu");

		try {
			while (true) {
				final MenuChoice options[] = {
						new MenuChoice("Coin Sort", new SortCoinsCommand()),
						new MenuChoice("see details", new DetailsSubMenuCommand()),
						new MenuChoice("configure", new ConfigurationSubMenuCommand()),
						MenuChoice.QUIT };
				menu.getCommand(options).perform(sorter);
			}
		} catch (EndAppException e) {
			// End of app, do nothing
		}

	}

}
