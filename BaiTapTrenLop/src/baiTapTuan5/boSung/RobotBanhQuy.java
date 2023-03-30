package baiTapTuan5.boSung;

public class RobotBanhQuy extends SoftwareLapRap{
	

	public RobotBanhQuy(String name) {
		super(name);
	}

	@Override
	public void layLinhKien() {
		System.out.println("Getting flour and sugar ...");
		
	}

	@Override
	public void lapRap() {
		System.out.println("Baking a cookie ...");
		
	}

	@Override
	public void kiemTra() {
		System.out.println("Crunching a cookie ...");
	}
}
