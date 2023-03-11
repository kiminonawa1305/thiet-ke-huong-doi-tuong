package dau_gia_san_pham;

import java.util.*;


public class Systems extends Observable{
	private List<ItemType> listType;
	private Set<Person> listAccount;

	
	public Systems() {
		super();
		this.listType = new ArrayList<>();
		this.listAccount = new HashSet<>();
	}

	/**
	 * 
	 * @param bid
	 */
	public void setBid(Bid bid) {
		bid.setBid();
	}
	
	public void getWinnerBid(Item item) {
		item.getWinner();
		
		/**
		 * Thông báo từ hệ thống đến người bán đấu giá.
		 */
		this.setChanged();
		this.notifyObservers(item);
	}
	
	public boolean auction(String type, Item item) {
		for(ItemType itemType : listType) {
			if(itemType.equalsType(type)) {
				if(itemType.getListItem().contains(item)) {
					System.out.println("Đăng kí không thành công!");
					return false;
				}
				itemType.getListItem().add(item);
			}
		}
		
		ItemType newType = new ItemType(type, new ArrayList<>());
		newType.addItem(item);
		listType.add(newType);
		return true;
	}
}