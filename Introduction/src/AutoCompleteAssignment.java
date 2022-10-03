import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutoCompleteAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//enter search text in autosuggest field
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
				
		Thread.sleep(3000);
		
		//watch the keys.DOWN movement, as it populates the search field
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);	
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		
		Thread.sleep(3000);
		
		//another search text to loop through and populate the search field with the matching text.
		
		driver.findElement(By.id("autocomplete")).clear();
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		Thread.sleep(3000);		
		
		List<WebElement> countryDriver = driver.findElements(By.className("ui-menu-item-wrapper"));
		
		for(int i=0;i<countryDriver.size();i++)
		{
			
			if(countryDriver.get(i).getText().equalsIgnoreCase("United Arab Emirates"))
			{
				countryDriver.get(i).click();
			}

		}
	}

}
