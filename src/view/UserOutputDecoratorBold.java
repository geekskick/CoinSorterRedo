package view;

public class UserOutputDecoratorBold extends UserOutputDecorator {

	public UserOutputDecoratorBold(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		LineOutput.INSTANCE.show("\u001b[1m");
		super.show(message);
		LineOutput.INSTANCE.show("\u001b[0m");
	}

}
