import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
			
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//parent-sibling traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button/following-sibling::button[1]")).getText());
		
		//sibling to parent reverse traverse
		
		System.out.println(driver.findElement(By.xpath("//header/div/button/following-sibling::button[1]/parent::div/button[1]")).getText());

	}

}
