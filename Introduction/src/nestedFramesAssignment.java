import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class nestedFramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		
		//click on Nested Frames link
		driver.findElement(By.linkText("Nested Frames")).click();	
		
		//switch to the middle frame - Nested frames
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		//get text from middle from
		System.out.println(driver.findElement(By.id("content")).getText());
		
		//switch to parent webpage. [driver.switchTo().parentFrame() to switch to parent frame]
		driver.switchTo().defaultContent(); 
	}

}
