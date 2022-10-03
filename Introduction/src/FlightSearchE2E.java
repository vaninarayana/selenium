import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightSearchE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
			
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
		driver.manage().window().maximize();
		
		//select One Way
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//select From city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		//wait for destinations to load
		Thread.sleep(2000l);
		
		//select To city
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//select current date as departure date
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
			System.out.println("Its Disabled");
		}
		else
		{
			Assert.assertTrue(false);
		}		
		
		//select Senior Citizen checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();	
		
		//select number of Adults.
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<3)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		//using assertEquals
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//click 'Done'
		driver.findElement(By.id("btnclosepaxoption")).click();	
		
		//static dropdown selection for currency
		
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(staticdropdown);
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Hit Submit
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
	}

}
