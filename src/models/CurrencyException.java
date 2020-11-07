package models;

public class CurrencyException extends Exception {
	private static final long serialVersionUID = 1L;

	public CurrencyException(String errorMessage) {
		super(errorMessage);
	}
}
