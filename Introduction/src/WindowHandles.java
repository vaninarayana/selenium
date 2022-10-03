import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//click on blinking green text to open in a new window
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//get newly opened windows id / handle
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		//switch driver to child window
		driver.switchTo().window(childId);
		
		//get text from child window
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//extract email details from the text
		System.out.println("Extracted email id is : "+emailId);		
		
		//swicth back to parent window
		driver.switchTo().window(parentId);
		
		//populate username field with extracted email id
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
