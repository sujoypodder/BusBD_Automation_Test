package com.busbd.objpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchmenu_leavingform\"]")
	@CacheLookup
	WebElement from;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchmenu_goingto\"]")
	@CacheLookup
	WebElement to;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchmenu_departingon\"]")
	@CacheLookup
	WebElement on;

	@FindBy(id = "searchmenu_coachtype")
	@CacheLookup
	WebElement type;

	@FindBy(id = "searchmenu_submitbutton")
	@CacheLookup
	WebElement srcbtn;

	public static void SelectDateByJs(WebDriver driver, WebElement ele, String dvalue) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dvalue + "');", ele);
	}

	public void setLeaveFrom() {
		Select fm = new Select(from);
		fm.selectByVisibleText("DHAKA");
	}

	public void setGoTo() {
		Select tt = new Select(to);
		tt.selectByVisibleText("COX'S BAZAR");
	}

	public void setDepartOn() throws InterruptedException {
		String inval = "22-09-2020";
		SelectDateByJs(ldriver, on, inval);
		Thread.sleep(1000);
	}

	public void setCoachType() {
		Select ct = new Select(type);
		ct.selectByVisibleText("NonAc");
	}

	public void Submit() {
		srcbtn.click();
	}

}
