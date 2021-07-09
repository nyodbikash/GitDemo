package com.nt.service.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.nt.servicr.BankService;

public class TestBankService {
	
	private static BankService service;
	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestBankService.setUpOnce");
		service=new BankService();
	}
	/*
	 * @BeforeEach public void setUp() {
	 * System.out.println("TestBankService.setup"); service=new BankService(); }
	 */
	
	@Test
	public void testCalcSimpleInterestAmtWithSmallNo() {
		System.out.println("TestBankService.testCalcSimpleInterestAmtWithSmallNo");
		float actual = service.calcSimpleInterestAmt(100000, 2, 12);
		float expected=24000.0f;
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testCalcSimpleInterestAmtWithBigNo() {
		System.out.println("TestBankService.testCalcSimpleInterestAmtWithBigNo");
		float actual = service.calcSimpleInterestAmt(10000000, 2, 12);
		float expected=2400000.0f;
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testCalcSimpleInterestAmtWithWrongInput() {
		System.out.println("TestBankService.testCalcSimpleInterestAmtWithWrongInpu");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			service.calcSimpleInterestAmt(0, 0, 0);
		},"my thrown exception is not raised");
	}
	@Test
	public void testCalcSimpleInterestAmtWithTimer() {
		System.out.println("TestBankService.testCalcSimpleInterestAmtwithTimer");
		Assertions.assertTimeout(Duration.ofMillis(2000), ()->{
			service.calcSimpleInterestAmt(1000000, 3, 12);
		});
	}
	
	/*
	 * @AfterEach public void clear() { System.out.println("TestBankService.clear");
	 * service=null; }
	 */

	@AfterAll
	public static void clearOnce() {
		System.out.println("TestBankService.clearOnce");
		service=null;
	}
}
