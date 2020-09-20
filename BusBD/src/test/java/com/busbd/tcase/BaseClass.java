package com.busbd.tcase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.busbd.extra.ReadConfig;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getAppUrl();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			FirefoxOptions opt = new FirefoxOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver();
		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		// driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/SShots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

	public void pdfCapture(WebDriver driver, String name) throws DocumentException, MalformedURLException, IOException {
		byte[] input = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Document doc = new Document();
		String output = "C:\\Users\\88016\\eclipse-workspace\\BusBD\\SShots\\" + name + ".pdf";
		FileOutputStream fos = new FileOutputStream(output);
		PdfWriter writer = PdfWriter.getInstance(doc, fos);
		writer.open();
		doc.open();
		Image img = Image.getInstance(input);
		img.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight() / 2);
		doc.add(img);
		doc.add(new Paragraph(" "));
		doc.close();
		writer.close();
	}

}
