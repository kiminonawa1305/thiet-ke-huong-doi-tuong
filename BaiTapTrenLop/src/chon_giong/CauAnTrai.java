package chon_giong;

public abstract class CauAnTrai implements Cay {
	protected String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}