package view;

public class UserOutputDecoratorGreen extends UserOutputDecorator {

	protected UserOutputDecoratorGreen(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		LineOutput.INSTANCE.show("\u001b[32m");
		super.show(message);
		LineOutput.INSTANCE.show("\u001b[0m");
	}

}
