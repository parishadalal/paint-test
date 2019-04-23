package paintTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
	
	public static WebDriver driver;
	public static String chromepath = "/Users/PARISHA/Desktop/SeleniumTutorial/chromedriver";
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", chromepath );
		driver = new ChromeDriver(); //launch chrome browser
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://127.0.0.1:5000/");
		Thread.sleep(300);
		
	}
	
	@Test(priority = 1, description = "Verify Negative values are not accepted" , groups = {"FieldValidation"})
	static void test0() throws InterruptedException{
		
		driver.findElement(By.id("room")).sendKeys("-6");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(300);
		
		String room = driver.findElement(By.id("room")).getText();
		System.out.println(room);
		Thread.sleep(300);
	}
	
	@Test(priority = 2,  description = "Verify Blank values are not accepted" , groups = {"FieldValidation"})
	static void test1() throws InterruptedException{
		
		driver.findElement(By.id("room")).sendKeys("");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();
		
		String room = driver.findElement(By.id("room")).getText();
		System.out.println(room);
		Assert.assertEquals("", room);
		Thread.sleep(300);
	}
	
	@Test(priority = 3, description = "Verify Decimal values are not accepted" , groups = {"FieldValidation"})
	static void test2() throws InterruptedException{
		
		driver.findElement(By.id("room")).sendKeys("2.5");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();
		
		String room = driver.findElement(By.id("room")).getText();
		System.out.println(room);
		Thread.sleep(300);
	}

	@Test(priority = 4 , description = "Single Room with integer values" , groups = {"Calculator"})
	static void test3() throws InterruptedException  {
		
		driver.findElement(By.id("room")).sendKeys("1");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();

		driver.findElement(By.id("length-0")).sendKeys("20");
		Thread.sleep(300);
		driver.findElement(By.id("width-0")).sendKeys("20");
		Thread.sleep(300);
		driver.findElement(By.id("height-0")).sendKeys("5");
		Thread.sleep(300);

		driver.findElement(By.id("submit")).click();
		Thread.sleep(300);


		String room1 = driver.findElement(By.id("room1")).getText();
		System.out.println(room1);
		Assert.assertEquals("1", room1 , " room result is not matched");
		
		String ftresult1 = driver.findElement(By.id("ftresult1")).getText();
		System.out.println(ftresult1);
		Assert.assertEquals("400.0", ftresult1 , " foot area result is not matched");
		
		String totalgallon = driver.findElement(By.id("totalgallon")).getText();
		System.out.println(totalgallon);
		Assert.assertEquals("Total Gallons Required: 1", totalgallon , " total gallon result is not matched");
		
		Thread.sleep(300);

	}
	
	@Test(priority = 5,description = "Single Room with decimal values" , groups = {"Calculator"})
	static void test4() throws InterruptedException  {
		
		driver.findElement(By.id("room")).sendKeys("1");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();

		driver.findElement(By.id("length-0")).sendKeys("10.2");
		Thread.sleep(300);
		driver.findElement(By.id("width-0")).sendKeys("10.9");
		Thread.sleep(300);
		driver.findElement(By.id("height-0")).sendKeys("2.5");
		Thread.sleep(300);

		driver.findElement(By.id("submit")).click();
		Thread.sleep(300);
		
		String room1 = driver.findElement(By.id("room1")).getText();
		System.out.println(room1);
		Assert.assertEquals("1", room1, " room result is not matched");
		
		String ftresult1 = driver.findElement(By.id("ftresult1")).getText();
		System.out.println(ftresult1);
		Assert.assertEquals("105.5", ftresult1 , " foot area result is not matched");
		
		String totalgallon = driver.findElement(By.id("totalgallon")).getText();
		System.out.println(totalgallon);
		Assert.assertEquals("Total Gallons Required: 1", totalgallon , " total gallon result is not matched");
		
		Thread.sleep(300);
	}
	
	
	@Test(priority = 6,description = "Multiple Rooms Calculations" , groups = {"Calculator"})
	static void test5() throws InterruptedException  {
		driver.findElement(By.id("room")).sendKeys("3");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("length-0")).sendKeys("20");
		Thread.sleep(300);
		driver.findElement(By.id("width-0")).sendKeys("40");
		Thread.sleep(300);
		driver.findElement(By.id("height-0")).sendKeys("5");
		Thread.sleep(300);
		
		driver.findElement(By.id("length-1")).sendKeys("20");
		Thread.sleep(300);
		driver.findElement(By.id("width-1")).sendKeys("20");
		Thread.sleep(300);
		driver.findElement(By.id("height-1")).sendKeys("6");
		Thread.sleep(300);
		
		driver.findElement(By.id("length-2")).sendKeys("40");
		Thread.sleep(300);
		driver.findElement(By.id("width-2")).sendKeys("40");
		Thread.sleep(300);
		driver.findElement(By.id("height-2")).sendKeys("10");
		Thread.sleep(300);
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(300);
	
		String room1 = driver.findElement(By.id("room1")).getText();
		System.out.println(room1);
		Assert.assertEquals("1" , room1, " room result is not matched");
		
		String ftresult1 = driver.findElement(By.id("ftresult1")).getText();
		System.out.println(ftresult1);
		Assert.assertEquals("600.0", ftresult1 , " foot area result is not matched");
		
		String room2 = driver.findElement(By.id("room2")).getText();
		System.out.println(room2);
		Assert.assertEquals("2" , room2, " room result is not matched");
		
		String ftresult2 = driver.findElement(By.id("ftresult2")).getText();
		System.out.println(ftresult2);
		Assert.assertEquals("480.0", ftresult2 , " foot area result is not matched");
		
		String room3 = driver.findElement(By.id("room3")).getText();
		System.out.println(room3);
		Assert.assertEquals("3" , room3, " room result is not matched");
		
		String ftresult3 = driver.findElement(By.id("ftresult3")).getText();
		System.out.println(ftresult3);
		Assert.assertEquals("1600.0", ftresult3 , " foot area result is not matched");
		
		String totalgallon = driver.findElement(By.id("totalgallon")).getText();
		System.out.println(totalgallon);
		Assert.assertEquals("Total Gallons Required: 8", totalgallon , " total gallon result is not matched");
		
		Thread.sleep(300);
	}

	@Test(priority = 7,description = "Rounding Calculation" , groups = {"Calculator"})
	static void test6() throws InterruptedException  {
		
		driver.findElement(By.id("room")).sendKeys("1");
		Thread.sleep(300);
		driver.findElement(By.id("submit")).click();

		driver.findElement(By.id("length-0")).sendKeys("25");
		Thread.sleep(300);
		driver.findElement(By.id("width-0")).sendKeys("25");
		Thread.sleep(300);
		driver.findElement(By.id("height-0")).sendKeys("5");
		Thread.sleep(300);

		driver.findElement(By.id("submit")).click();
		Thread.sleep(300);
		
		String room1 = driver.findElement(By.id("room1")).getText();
		System.out.println(room1);
		Assert.assertEquals("1", room1, " room result is not matched");
		
		String ftresult1 = driver.findElement(By.id("ftresult1")).getText();
		System.out.println(ftresult1);
		Assert.assertEquals("500.0", ftresult1 , " foot area result is not matched");
		
		String totalgallon = driver.findElement(By.id("totalgallon")).getText();
		System.out.println(totalgallon);
		Assert.assertEquals("Total Gallons Required: 2", totalgallon , " total gallon result is not matched");
		
		Thread.sleep(300);
	}
	
	@AfterMethod
	public void quit() {
		
		driver.quit();
		
	}
		
}