package VideoRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;
	private List<RentItem> rentItems = new ArrayList<>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RentItem> getRentItem() {
		return rentItems;
	}

	public void setRentItem(List<RentItem> rentItems) {
		this.rentItems = rentItems;
	}

	/**
	 * Phương thức rent là phương thức thuê phim và mỗi khách chỉ được thuê tối đa 5
	 * phim
	 * 
	 * @param movie
	 * @param days
	 */
	public void rent(Movie movie, Date startDate) {
		if (this.rentItems.size() < 6) {
			this.rentItems.add(new RentItem(startDate, movie));
			movie.setAvailabe(true);
			System.out.println("Qúy khách đã thuê thành công");
		} else {
			System.out.println("Số lượng phim thuê của quý khách đã vượt quá 5 bộ; Không thể mượn thêm nữa!");
		}
	}

	/**
	 * Phương thức returnMovie là phương thức trả phim của khách hàng,
	 * @param movie
	 */
	public void returnMovie(Movie movie) {
		if(this.rentItems.contains(movie)) {
			this.rentItems.remove(movie);
			System.out.println("Quý khách đã trả phim thành công!");
		}else {
			System.out.println("Hệ thống không ghi nhận quý khách đã mượn bộ phim này!");
		}
	}

	/**
	 * Phương thức statement là phương thức im hóa đơn
	 * @return
	 */
	public String statement() {
		String result = "Hóa đơn của " + this.name + "\n";
		for(RentItem rent : this.rentItems) {
			result += rent.getMovie().getTitle() + " \t" + rent.getCharge() + "\n";
		}
		result += "Tổng số tiền phải trả là: " + this.totalCharge() + "\n" + 
		"Tổng điểm thưởng của quý khách là: " + this.totalPoints();
		
		return result;
	}

	private int totalPoints() {
		int total = 0;
		for(RentItem rent : this.rentItems) {
			total += rent.getFrequentRenterPoints();
		}
		return total;
	}

	private double totalCharge() {
		double total = 0;
		for(RentItem rent : this.rentItems) {
			total += rent.getCharge();
		}
		return total;
	}
}
