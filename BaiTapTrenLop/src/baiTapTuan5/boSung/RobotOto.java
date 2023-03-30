package baiTapTuan5.boSung;

public class RobotOto extends SoftwareLapRap{

	public RobotOto(String name) {
		super(name);
	}

	@Override
	public void layLinhKien() {
		System.out.println("Getting a carburetor ...");
	}
	
	@Override
	public void lapRap() {
		System.out.println("Installing the carburetor ...");
		
	}

	@Override
	public void kiemTra() {
		System.out.println("Revving the engine ...");
	}
}
