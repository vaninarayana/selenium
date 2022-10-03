import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//JavascriptExecutor for scroll window  / table
		
		JavascriptExecutor jsExec = (JavascriptExecutor)driver;
		
		//scroll to the middle of the page where the table is
		jsExec.executeScript("window.scrollBy(0,500)");
		
		//wait 3 seconds to be able to see both scrolls
		Thread.sleep(3000);
		
		//scroll to the middle of the table
		jsExec.executeScript("document.querySelector('.tableFixHead').scrollTop=60");
		
		//get all the number elements in the Amount columns to sum up
		List<WebElement> tbAmnt = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
		int addedTotal = 0; 
		
		//parse thro the elements and get the total sum
		for(int i=0;i<tbAmnt.size();i++)
		{
			addedTotal = addedTotal + Integer.parseInt(tbAmnt.get(i).getText());
		}
		
		//get the printed sum total from the page
		int printedTotal = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		
		//compare and test
		Assert.assertEquals(addedTotal, printedTotal);
		
	}

}
