package model_pay;

import model_system.Bill;

public class Card implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue, double moneyReceived) {
		return bill.getPay(thue) <= moneyReceived;
	}

}