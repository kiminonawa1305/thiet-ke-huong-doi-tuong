package baiTapTuan5.boSung;

public abstract class SoftwareLapRap {
	protected String name;
	
	public SoftwareLapRap(String name) {
		name = name;
		System.out.println(name);
		this.batDau();
		this.layLinhKien();
		this.lapRap();
		this.kiemTra();
		this.ketThuc();
	}

	public void batDau() {
		System.out.println("Strating ...");
	}

	public abstract void layLinhKien();

	public abstract void lapRap();

	public abstract void kiemTra();

	public void ketThuc() {
		System.out.println("Stopping ...");
	}
	
	public static void main(String[] args) {
		SoftwareLapRap oto = new RobotOto("Automotive Robot:");
		System.out.println("-----------------------------");
		SoftwareLapRap banhQuy = new RobotBanhQuy("Cookie Robot:");
	}
}
