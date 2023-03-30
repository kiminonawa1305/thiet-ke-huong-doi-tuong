package chon_giong;

import java.util.ArrayList;
import java.util.List;

public class TN extends Factory {

	public List<Cay> chonGiong() {
		List<Cay> re = new ArrayList<>();
		re.add(new CaPhe());
		re.add(new Tieu());
		re.add(new CaoSu());
		
		
		return re;
	}

}