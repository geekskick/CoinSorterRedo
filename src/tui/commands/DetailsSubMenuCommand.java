package tui.commands;

import exceptions.EndAppException;
import models.CoinSorter;
import tui.Menu;
import tui.MenuChoice;

public class DetailsSubMenuCommand implements Command {

	@Override
	public void perform(CoinSorter coinsorter) throws EndAppException {
		
		MenuChoice details_submenu[] = new MenuChoice[] {
			new MenuChoice("show currency", new ShowCurrencyCommand()),
			new MenuChoice("show limits", new ShowLimitCommand()),
			new MenuChoice("go back", new QuitCommand())
		};
		
		final Menu menu = new Menu("Details Submenu");
		
		try {
			while(true) {
				menu.getCommand(details_submenu).perform(coinsorter);
			}
		} catch(EndAppException e) {
			
		}
		
		
	}

}
