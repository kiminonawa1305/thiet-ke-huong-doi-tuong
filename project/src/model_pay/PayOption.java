package model_pay;

import model_system.*;

public interface PayOption {

	/**
	 * 
	 * @param bill
	 * @param moneyReceived
	 */
	boolean getPay(Bill bill, double moneyReceived);

}