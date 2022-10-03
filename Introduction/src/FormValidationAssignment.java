import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FormValidationAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
			
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		
		//implicitly wait 5 seconds for the success message after Submit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//fill in the form
		driver.findElement(By.name("name")).sendKeys("Vani Narayana");
		driver.findElement(By.name("email")).sendKeys("vanin@xyz.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("vani123");
		
		//checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		
		//static dropdown selection
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select selOptions = new Select(dropdown);
		selOptions.selectByVisibleText("Female");
		
		//select Student radio button
		driver.findElement(By.id("inlineRadio1")).click();
		
		//DOB
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("08/08/1985");
		
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//print success msg
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}

}
