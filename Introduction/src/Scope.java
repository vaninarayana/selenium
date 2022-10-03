import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// get total href link count from page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// get total href links count from footer div . LIMITING WebDriver Scope

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));

		System.out.println("footer: " + footerdriver.findElements(By.tagName("a")).size());

		// get total href links count from the first column in the footer .

		// WebElement colDriver = footerdriver.findElement(By.xpath("(//ul)[1]"));
		WebElement colDriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println("first column link count " + colDriver.findElements(By.tagName("a")).size());

		// open 4 links from the first column, all in new tabs
		for (int i = 1; i < colDriver.findElements(By.tagName("a")).size(); i++) {

			String newTabKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
			colDriver.findElements(By.tagName("a")).get(i).sendKeys(newTabKeys);
			Thread.sleep(3000);

		}

		//get the page titles of all the open tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		
		//loop thro' window handles
		while (it.hasNext()) 
		{
			driver.switchTo().window(it.next());

			System.out.println(driver.getTitle());
		}

		driver.switchTo().window(parentId);
	}

}
