package view;

public class UserOutputDecoratorFailure extends UserOutputDecorator {

	public UserOutputDecoratorFailure(UserOutput wrapee) {
		super(wrapee);
	}

	@Override
	public void show(String message) {
		new UserOutputDecoratorBold(new UserOutputDecoratorRed(LineOutput.INSTANCE)).show("[FAILED] ");
		super.show(message);
	}

}
