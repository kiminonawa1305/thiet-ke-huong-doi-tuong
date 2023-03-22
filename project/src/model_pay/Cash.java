package model_pay;

import model_system.Bill;

public class Cash implements PayOption {

	@Override
	public boolean getPay(Bill bill, double moneyReceived) {
		// TODO Auto-generated method stub
		return false;
	}
}