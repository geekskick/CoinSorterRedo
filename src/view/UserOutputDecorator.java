package view;

public class UserOutputDecorator implements UserOutput{
	
	protected UserOutput wrapped;
	
	protected UserOutputDecorator(UserOutput wrapee) {
		wrapped = wrapee;
	}

	@Override
	public void show(String message) {
		wrapped.show(message);
	}
	
	
	
}
