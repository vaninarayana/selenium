import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//open a new empty window tab and get window handles. Use WindowType.WINDOW for new window
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/");
		
		//get the name of the first course listed on the page and populate it in the name field of the parent window.
		
		String firstCourse = driver.findElement(By.xpath("(//div[@class='upper-box']/h2/a)[1]")).getText();
		
		driver.switchTo().window(parentId);
		
		WebElement nameDriver = driver.findElement(By.name("name"));
		nameDriver.sendKeys(firstCourse);
		
		//get partial screenshot of the name field 
		
		File scrshotFile = nameDriver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrshotFile, new File("field.png"));
		
		//GEt Height & Width of the name field and print

		System.out.println(nameDriver.getRect().getDimension().getHeight());

		System.out.println(nameDriver.getRect().getDimension().getWidth());		

	}

}
