package view;

public class UserOutputDecoratorRed extends UserOutputDecorator {

	protected UserOutputDecoratorRed(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		System.out.print("\u001b[31m");
		super.show(message);
		System.out.print("\u001b[0m");
	}

}
