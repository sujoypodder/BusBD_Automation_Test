package com.busbd.tcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.busbd.objpage.BuyTicketPage;
import com.busbd.objpage.SearchPage;
import com.itextpdf.text.DocumentException;

public class TC_BuyTicket_002 extends BaseClass {

	@Test
	public void buyTicket() throws InterruptedException, IOException, DocumentException {
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
		Thread.sleep(1000);

		BuyTicketPage btp = new BuyTicketPage(driver);
		btp.getAllBusList();
		Thread.sleep(1000);
		btp.SitNo();
		Thread.sleep(1000);
		btp.passName("Hector Belerin");
		Thread.sleep(1000);
		btp.passMobile("01647652652");
		Thread.sleep(1000);
		btp.passEmail("blowing.up017@gmail.com");
		Thread.sleep(1000);
		btp.passGender();
		Thread.sleep(1000);
		btp.passAge("25");
		Thread.sleep(1000);
		btp.passAddress("Mirzapur, Tangail");
		Thread.sleep(1000);
		btp.passNid("31947865234");
		Thread.sleep(1000);
		btp.passNationality();
		Thread.sleep(1000);
		btp.bordingPoint();
		Thread.sleep(1000);
		btp.dropPoint();
		Thread.sleep(1000);
		btp.paymentMethod();
		Thread.sleep(1000);
		btp.ticketConfirm();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);

		String expectedUrl = "http://busbd.com.bd/en_US/ajax/onlineseatbooking/bkash/bkashseatbooking";
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals(expectedUrl)) {
			Assert.assertTrue(true);
			System.out.println("pass");
			captureScreen(driver, "TicketConfirmTest");
		} else {
			Assert.assertTrue(false);
			System.out.println("fail");
			pdfCapture(driver, "pagepdf");
		}
	}
}
