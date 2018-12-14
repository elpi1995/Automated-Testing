package com.cognizant.testing.TheDemoSite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class demoTest {
	WebDriver driver;
	
	static ExtentReports reports;
	ExtentTest tests;
	@BeforeClass
	public static void initial() {
		reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Foldery\\SillyReporty.html",true);
	}
	
	@AfterClass
	public static  void end() {
		reports.close();
	}
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.loginURL);
		
		System.out.println("Before");
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");
		reports.endTest(tests);
		reports.flush();
		driver.quit();
	}
	@Test
	public void loginUser() throws IOException {
		tests = reports.startTest("Silly");
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\SeleniumExamples\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		try {
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

				Cell username = sheet.getRow(i).getCell(0);
				Cell password = sheet.getRow(i).getCell(1);

				String user = username.getStringCellValue();
				String pass = password.getStringCellValue();
				tests.log(LogStatus.INFO, "navigate to demosite homepage");

				tests.log(LogStatus.INFO, "inputting new username");
				
				WebElement addUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
				addUser.click();
				WebElement userNameBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
				userNameBox.sendKeys(user);
				WebElement userPassBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
				userPassBox.sendKeys(pass);
				WebElement submitUser = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
				submitUser.click();
				WebElement loginUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
				loginUser.click();
				WebElement loginNameBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
				WebElement loginPassBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
				loginNameBox.sendKeys(user);
				loginPassBox.sendKeys(pass);
				WebElement login = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
				login.click();
				WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			
			if(success.isDisplayed()) {
				tests.log(LogStatus.PASS, "It has logged in");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found blouse");
				fail();
			}
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}	
	}

}
