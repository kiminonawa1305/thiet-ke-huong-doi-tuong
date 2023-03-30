package chon_giong;

public class Test {
	public static void main(String[] args) {
		TrungTam tn = new KhuVucTN();
		tn.chonGiong(new TN());
		tn.getListCay();
		
		TrungTam slc = new KhuVucSCL();
		slc.chonGiong(new SCL());
		slc.getListCay();
		slc.tangSanLuong("Xoài", 3);
	}
}
