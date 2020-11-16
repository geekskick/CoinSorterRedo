package view;

public class LineOutput implements UserOutput {

	public static final UserOutput INSTANCE = new LineOutput();
	
	@Override
	public void show(String message) {
		System.out.print(message);
	}
}
