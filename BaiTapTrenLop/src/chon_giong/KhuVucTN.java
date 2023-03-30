package chon_giong;

import java.util.List;

public class KhuVucTN implements TrungTam {

	private List<Cay> listCay;

	/**
	 * 
	 * @param factory
	 */
	public List<Cay> chonGiong(Factory factory) {
		this.listCay = factory.chonGiong();
		return this.listCay;
	}

	/**
	 * 
	 * @param cay
	 * @param sl
	 */
	public void tangSanLuong(String cay, double sl) {
		for(Cay c : listCay) {
			if(c.getName().equalsIgnoreCase(cay)) {
				System.out.println(cay + " tăng sản lượng lên " + sl);
			}
		}
	}

	@Override
	public void getListCay() {
		System.out.println(this.listCay);
	}

}