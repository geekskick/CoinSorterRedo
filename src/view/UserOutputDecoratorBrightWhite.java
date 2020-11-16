package view;

public class UserOutputDecoratorBrightWhite extends UserOutputDecorator {

	public UserOutputDecoratorBrightWhite(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		LineOutput.INSTANCE.show("\u001b[37;1m");
		super.show(message);
		LineOutput.INSTANCE.show("\u001b[0m");
	}

}
