package DayOne;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReadClass {
	WebDriver driver;
	ExcelRead excelFile = new ExcelRead();
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(excelFile.readExcel(1,0,".\\Data\\test.xlsx","Sheet1"));
	}

@Test

	public void testSearch() throws IOException
	{
	driver.findElement(By.name("q")).sendKeys(excelFile.readExcel(1,1,".\\Data\\test.xlsx","Sheet1"));
	//driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();
	
	String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, "Selenium - Web Browser Automation");
	}
	@AfterTest
		public void tearDown()
		{
			driver.close();
			driver.quit();
		}

}
