package com.nt.servicr;

public class BankService {
	public float calcSimpleInterestAmt(float pAmt,float rate, int time) {
		if(pAmt<=0 || rate<=0|| time<=0)
			throw new IllegalArgumentException("Invalid argument");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (pAmt*rate*time)/100.0f;
	}

}
