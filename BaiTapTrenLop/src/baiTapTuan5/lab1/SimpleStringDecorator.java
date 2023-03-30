package baiTapTuan5.lab1;

public class SimpleStringDecorator extends StringDecorator {
	protected char getBottomCharacter() {
		return '#';
	}

	protected char getLeftCharacter() {
		return '(';
	}

	protected char getRightCharacter() {
		return ')';
	}

	protected String getString() {
		return "javabeat.net";
	}

	protected char getTopCharacter() {
		return '#';
	}

	public static void main(String[] args) {
		StringDecorator decorator = new SimpleStringDecorator();
		decorator.decorate();
	}
}
