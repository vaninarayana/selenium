import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.orbitz.com/");
		
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		//clcik on Calendar field
		driver.findElement(By.id("d1-btn")).click();
		
		//wait for calendar to open
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("\"(//div[@class='uitk-date-picker-menu-months-container']/div/h2)[1]")));
		
		//keep looping / clicking until the desired Month / Year
		while(!driver.findElement(By.xpath("(//div[@class='uitk-date-picker-menu-months-container']/div/h2)[1]")).getText().contains("January 2023"))
		{
			//wait for new month to load after every click
			expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='uitk-calendar'] button:nth-child(2)")));
			driver.findElement(By.cssSelector("div[class='uitk-calendar'] button:nth-child(2)")).click();
		}
		
		//get all loaded month dates in a WebElement
		List<WebElement> calDays = driver.findElements(By.className("uitk-date-picker-day"));
		
		//loop through the dates and find the correct match
		for(int i=0;i<calDays.size();i++)
		{
			if(driver.findElements(By.className("uitk-date-picker-day")).get(i).getAttribute("data-day").equalsIgnoreCase("3"))
			{
				driver.findElements(By.className("uitk-date-picker-day")).get(i).click();
				break;
			}
		}
		
	}

}
