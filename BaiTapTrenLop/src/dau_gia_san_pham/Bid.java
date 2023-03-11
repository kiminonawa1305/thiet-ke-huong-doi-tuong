package dau_gia_san_pham;

import java.util.Observable;

public class Bid extends Observable{
	private Date createDate;
	private double amount;
	private Item item;
	private Person bidder;

	public Bid(Date createDate, double amount, Item item, Person bidder) {
		super();
		this.createDate = createDate;
		this.amount = amount;
		this.item = item;
		this.bidder = bidder;
		this.addObserver(item);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Person getBidder() {
		return bidder;
	}

	public void setBidder(Person bidder) {
		this.bidder = bidder;
	}

	public boolean equalsItem(Item item) {
		return this.item.equals(item);
	}
	
	public boolean checkTime(Date start, Date end) {
		return this.createDate.checkTime(start, end);
	}
	
	public void setBid() {
		this.setChanged();
		this.notifyObservers(this.getItem());
		this.addObserver(bidder);
	}
	
	public void winner() {
		this.setChanged();
		this.notifyObservers();
	}
}