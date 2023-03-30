package baiTapTuan5.lab1;

public abstract class StringDecorator {
	// template method
	public final void decorate() {
		char topChar = getTopCharacter();
		char leftChar = getLeftCharacter();
		String str = getString();
		char rightChar = getRightCharacter();
		char bottomChar = getBottomCharacter();
		for (int i = 0; i < str.length() + 2; i++) {
			System.out.print(topChar);
		}
		System.out.println();
		System.out.print(leftChar);
		if (isUpperCase()) {
			System.out.print(str.toUpperCase());
		} else {
			System.out.print(str.toLowerCase());
		}
		System.out.print(rightChar);
		System.out.println();
		for (int i = 0; i < str.length() + 2; i++) {
			System.out.print(bottomChar);
		}
	}

	// hook method
	protected boolean isUpperCase() {
		return true;
	}

	protected abstract char getTopCharacter();

	protected abstract char getLeftCharacter();

	protected abstract String getString();

	protected abstract char getRightCharacter();

	protected abstract char getBottomCharacter();
}
