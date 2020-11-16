package view;

public class NewLineOutput implements UserOutput {

	public static final UserOutput INSTANCE = new NewLineOutput();
	
	@Override
	public void show(String message) {
		System.out.println(message);
	}

}
