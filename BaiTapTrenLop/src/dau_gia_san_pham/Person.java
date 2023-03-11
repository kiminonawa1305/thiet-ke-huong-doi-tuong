package dau_gia_san_pham;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
	private String name;
	private String userName;
	private String password;
	private String address;
	private String email;
	private BillingDetails billingDetails;

	public Person(String name, String userName, String password, String address, String email,
			BillingDetails billingDetails, Observable observable) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.billingDetails = billingDetails;
		observable.addObserver(this);
	}

	/**
	 * 
	 * @param type
	 * @param item
	 */
	public void signUpForAuction(String type, Item item, Systems systems) {
		if (systems.auction(type, item)) {
			item.setSeller(this);
			System.out.println("Đã đăng kí thành công item " + item);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Systems && arg instanceof Item) {
			Item item = (Item) arg;
			Bid winBid = item.getBidMaxAmount();
			if(item.getSeller().equals(this)) {
				System.out.println("Món hàng đấu giá " + item + " đã được bán thành công với giá " + winBid.getAmount());
				System.out.println("Người chiến thắng phiên đấu giá này là: " + winBid.getBidder());
			}
		}

		if (o instanceof Bid && arg == null) {
			Bid bid = (Bid) o;
			System.out.println("Chúc mừng bạn đã chiến thắng cuộc đấu giá sản phẩm " + bid.getItem());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Person that = (Person) obj;
			return this.name.equalsIgnoreCase(that.name) && this.userName.equals(that.userName)
					&& this.password.equals(that.password) && this.address.equalsIgnoreCase(that.address)
					&& this.email.equals(that.email);
		}

		return false;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", userName=" + userName + ", address=" + address + ", email=" + email + "]";
	}

}