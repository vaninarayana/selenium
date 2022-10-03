import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//SoftAssert to not break the script at first failure. Loop thro' all broken links.
		SoftAssert sa = new SoftAssert();
		
		//get all anchor links from the footer
		List<WebElement> pageLinks = driver.findElements(By.cssSelector(".gf-li a"));
		for(WebElement pageLink : pageLinks)
		{			
			String urlStr = pageLink.getAttribute("href");
			
			//check if href link is broken
			HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			//get link status code
			int respCode = conn.getResponseCode();		
			System.out.println(respCode);
		    //if status code > 400, the page link is broken. SoftAssert records failure and continues.
			sa.assertTrue(respCode<400, "The link '"+pageLink.getText()+"' is broken. Error Code "+respCode+".");
		}
		
		//SoftAssert checks for success / failure status and prints if failed.
		sa.assertAll();

		
	}

}
