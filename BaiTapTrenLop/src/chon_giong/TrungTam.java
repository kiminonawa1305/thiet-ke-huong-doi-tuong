package chon_giong;

import java.util.List;

public interface TrungTam {

	/**
	 * 
	 * @param factory
	 */
	List<Cay> chonGiong(Factory factory);

	/**
	 * 
	 * @param cay
	 * @param sl
	 */
	void tangSanLuong(String cay, double sl);

	void getListCay();

}