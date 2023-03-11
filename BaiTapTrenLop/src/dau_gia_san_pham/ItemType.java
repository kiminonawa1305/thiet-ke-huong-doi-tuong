package dau_gia_san_pham;

import java.util.List;

public class ItemType {

	private String title;
	private List<Item> listItem;
	public ItemType(String title, List<Item> listItem) {
		super();
		this.title = title;
		this.listItem = listItem;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == this.getClass()) {
			ItemType that = (ItemType) obj;
			return equalsType(that.title);
		}
		
		return false;
	}

	public boolean equalsType(String type) {
		return this.title.equalsIgnoreCase(type);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Item> getListItem() {
		return listItem;
	}
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}
	
	public boolean addItem(Item item) {
		return this.listItem.add(item);
	}
}