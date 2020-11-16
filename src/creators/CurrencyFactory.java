package creators;

import java.util.HashMap;
import java.util.Set;

import models.Currency;
import models.Sterling;

public class CurrencyFactory {
	@SuppressWarnings("serial")
	static private HashMap<String, Currency> allCurrencies = new HashMap<String, Currency>() {
		{
			put(new Sterling().getCode(), new Sterling());
		}
	};

	public static Currency getCurrency(String code) {
		return allCurrencies.get(code);
	}

	public static void addCurrency(String code, Currency curr) {
		allCurrencies.put(code, curr);
	}
	
	public static Set<String> availableCurrencies(){
		return allCurrencies.keySet();
	}
}
