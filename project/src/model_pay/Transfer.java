package model_pay;

import model_system.Bill;

public class Transfer implements PayOption {

	@Override
	public boolean getPay(Bill bill, double moneyReceived) {
		return bill.getTotalBill() <= moneyReceived;
	}
}