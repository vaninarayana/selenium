import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
			
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
		driver.manage().window().maximize();		
		
		driver.findElement(By.id("autosuggest")).sendKeys("le");
		//takes time to load the autosuggest options
		Thread.sleep(3000);
		//returning multiple elements, so findElements
		List<WebElement> listOptions =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement selOption : listOptions)
		{
			if(selOption.getText().equalsIgnoreCase("st. helena"))
			{
				selOption.click();
				break;
			}
		}
		

	}

}
