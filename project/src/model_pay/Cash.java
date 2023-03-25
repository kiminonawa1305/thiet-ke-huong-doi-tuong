package model_pay;

import model_system.Bill;

public class Cash implements PayOption {

	@Override
	public boolean getPay(Bill bill, double moneyReceived) {
		return bill.getTotalBill() <= moneyReceived;
	}
}