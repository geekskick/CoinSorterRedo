package view;

public class UserOutputDecoratorSuccess extends UserOutputDecorator {

	public UserOutputDecoratorSuccess(UserOutput wrapee) {
		super(wrapee);
	}
	
	@Override
	public void show(String message) {
		new UserOutputDecoratorGreen(LineOutput.INSTANCE).show("[SUCCESS] ");
		super.show(message);
		
	}

}
