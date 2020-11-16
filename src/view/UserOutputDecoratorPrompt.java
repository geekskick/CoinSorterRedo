package view;

public class UserOutputDecoratorPrompt extends UserOutputDecorator {

	protected UserOutputDecoratorPrompt(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		super.show(message);
		new UserOutputDecoratorBold(LineOutput.INSTANCE).show(">\t");
	}

}
