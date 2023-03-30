package chon_giong;

import java.util.ArrayList;
import java.util.List;

public class SCL extends Factory {

	public List<Cay> chonGiong() {
		List<Cay> re = new ArrayList<>();
		re.add(new Xoai());
		re.add(new Cam());
		re.add(new Nhan());
		re.add(new SauRieng());
		
		return re;
	}

}