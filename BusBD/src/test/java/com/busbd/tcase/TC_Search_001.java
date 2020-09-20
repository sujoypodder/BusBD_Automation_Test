package com.busbd.tcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.busbd.objpage.SearchPage;

public class TC_Search_001 extends BaseClass {

	@Test
	public void BuyTicket() throws InterruptedException, IOException {

		driver.get(baseUrl);
		SearchPage sp = new SearchPage(driver);
		sp.setLeaveFrom();
		Thread.sleep(1000);
		sp.setGoTo();
		Thread.sleep(1000);
		sp.setDepartOn();
		Thread.sleep(1000);
		sp.setCoachType();
		Thread.sleep(1000);
		sp.Submit();
		String expectedUrl = "http://busbd.com.bd/en_US/seatsearch";
		if (driver.getCurrentUrl().equals(expectedUrl)) {
			Assert.assertTrue(true);
			System.out.println("pass");
			captureScreen(driver, "SearchPageTest"); 
		} else {
			Assert.assertTrue(false);
			System.out.println("fail");
		}
	}

}
