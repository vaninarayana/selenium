import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamsWebTableFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//find out if search/filter field id working fine. 
		
		driver.findElement(By.id("search-field")).sendKeys("ch");
		
		List<WebElement> prodData = driver.findElements(By.xpath("//tr/td[1]")); 
		
		//convert text from table to lowercase before comparing. 
		
		List<WebElement> filteredList = prodData.stream().filter(s->s.getText().toLowerCase().contains("ch")).collect(Collectors.toList());
		
		Assert.assertEquals(prodData, filteredList);
	}

}
