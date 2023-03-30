package starbuzz_caffe;

public enum Size {
	BIG((double)4/3),
	MEDIUM(1),
	SMALL((double)2/3);

	private double percent;

	private Size(double percent) {
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
}