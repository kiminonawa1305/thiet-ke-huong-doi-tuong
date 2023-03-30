package chon_giong;

import java.util.List;

public class KhuVucSCL implements TrungTam {

	private List<Cay> listCay;

	/**
	 * 
	 * @param factory
	 */
	public List<Cay> chonGiong(Factory factory) {
		listCay = factory.chonGiong();
		return listCay;
	}

	/**
	 * 
	 * @param cay
	 * @param sl
	 */
	public void tangSanLuong(String cay, double sl) {
		for(Cay c : listCay) {
			if(c.getName().equalsIgnoreCase(cay)) {
				System.out.println(cay + " tăng sản lương lên " + sl);
			}
		}
	}

	@Override
	public void getListCay() {
		System.out.println(this.listCay);
	}

}