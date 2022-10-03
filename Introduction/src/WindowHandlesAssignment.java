import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//click on Multiple Windows link
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		//wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
		
		//click to open a new window
		driver.findElement(By.linkText("Click Here")).click();
		
		//get newly opened windows id / handle
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next(); 
		
		driver.switchTo().window(childId);
		
		//print text from child window
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		driver.switchTo().window(parentId);
		
		//print text from parent window
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
	}

}
