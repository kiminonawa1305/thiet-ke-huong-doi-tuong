package dau_gia_san_pham;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Item extends Observable implements Observer {
	private String name;
	private String description;
	private double initialPrice;
	private Date startDate;
	private Date endDate;
	private boolean state;
	private Person seller;
	private List<Bid> listBid;

	public Item(String name, String description, double initialPrice, Date startDate, Date endDate, boolean state,
			Person seller) {
		super();
		this.name = name;
		this.description = description;
		this.initialPrice = initialPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.seller = seller;
		this.listBid = new ArrayList<>();
	}

	public double maxAmount() {
		return listBid.stream().max((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount())).get().getAmount();
	}
	
	public Bid getBidMaxAmount() {
		return listBid.stream().max((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount())).get();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Bid && arg != null) {
			Bid bid = (Bid) o;
			System.out.println(this.name);
			if(this.listBid.isEmpty()) {
				if(bid.getAmount() > this.initialPrice) {
					this.getListBid().add(bid);
					System.out.println("Đấu giá thành công!");
				}else {
					System.out.println("Đấu giá không thành công!");
				}
			}else {
				if(bid.getAmount() > this.maxAmount()) {
					this.getListBid().add(bid);
					System.out.println("Đấu giá thành công!");
				}else {
					System.out.println("Đấu giá không thành công!");
				}
			}
			
			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Person getSeller() {
		return seller;
	}

	public void setSeller(Person seller) {
		this.seller = seller;
	}

	public List<Bid> getListBid() {
		return listBid;
	}

	public void setListBid(List<Bid> listBid) {
		this.listBid = listBid;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Item that = (Item) obj;
			return this.name.equalsIgnoreCase(that.name) && this.description.equalsIgnoreCase(that.description)
					&& this.initialPrice == that.initialPrice && startDate.equals(that.startDate)
					&& this.endDate.equals(that.endDate) && this.state == that.state && this.seller.equals(that.seller);
		}

		return false;

	}
	
	

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", initialPrice=" + initialPrice + ", startDate="
				+ startDate + ", endDate=" + endDate + ", seller=" + seller + "]";
	}

	public void getWinner() {
		this.getBidMaxAmount().winner();
	}
}