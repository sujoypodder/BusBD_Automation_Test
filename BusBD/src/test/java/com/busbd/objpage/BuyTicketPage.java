package com.busbd.objpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BuyTicketPage {

	WebDriver ldriver;

	public BuyTicketPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"viewseat-image_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement lnkForm;

	@FindBy(how = How.XPATH, using = "//*[@id=\"7337\"]")
	@CacheLookup
	WebElement sitno;

	@FindBy(how = How.XPATH, using = "//*[@id=\"buyer_name_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.ID, using = "mobile_number_4266e65b03608475faa281a111a5bf4b")
	@CacheLookup
	WebElement mobile;

	@FindBy(how = How.XPATH, using = "//*[@id=\"useremailaddress\"]")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@id=\"user_gender_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement gender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"buyer_age_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement age;

	@FindBy(how = How.XPATH, using = "//*[@id=\"buyer_address_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.XPATH, using = "//*[@id=\"buyer_passport_no_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement passid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"user_nationality_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement nationality;

	@FindBy(how = How.XPATH, using = "//*[@id=\"seatbookig-bordingpoint_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement borderpoint;

	@FindBy(how = How.XPATH, using = "//*[@id=\"seatbookig-droppingpoint_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement droppoint;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bank_payment_4266e65b03608475faa281a111a5bf4b\"]")
	@CacheLookup
	WebElement payment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"confirm-button_4266e65b03608475faa281a111a5bf4b\"]/span[1]")
	@CacheLookup
	WebElement btnConfirm;

	public void getAllBusList() {
		lnkForm.click();

	}

	public void SitNo() {
		sitno.click();
	}

	public void passName(String cname) {
		name.sendKeys(cname);
	}

	public void passMobile(String phn) {
		mobile.sendKeys(phn);
	}

	public void passEmail(String pemail) {
		email.sendKeys(pemail);
	}

	public void passGender() {
		Select pg = new Select(gender);
		pg.selectByVisibleText("Male");
	}

	public void passAge(String page) {
		age.sendKeys(page);
	}

	public void passAddress(String paddress) {
		address.sendKeys(paddress);
	}

	public void passNid(String pnid) {
		passid.sendKeys(pnid);
	}

	public void passNationality() {
		Select pn = new Select(nationality);
		pn.selectByVisibleText("Bangladeshi");
	}

	public void bordingPoint() {
		Select bp = new Select(borderpoint);
		bp.selectByValue("387");
	}

	public void dropPoint() {
		Select dp = new Select(droppoint);
		dp.selectByValue("1955");
	}

	public void paymentMethod() {
		Select pm = new Select(payment);
		pm.selectByVisibleText("bKash Payment");
	}

	public void ticketConfirm() {
		btnConfirm.click();
	}

}
