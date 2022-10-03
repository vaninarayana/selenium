import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);
		//implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		//this will throw an error without implicit wait
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		System.out.println(driver.findElement(By.cssSelector("label[for='chkboxOne']")).getText());
		//linkText locator
		driver.findElement(By.linkText("Forgot your password?")).click(); 

		    Thread.sleep(1000);

		//using xpath locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		//use indexes ONLY when there are no unique attributes. Here input type=text appears multiple times on the page.
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@gmail.com");
		//indexing may be different for xpath and cssSelector in some cases. Check in console / selectorshub to confirm
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9999999999"); 
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).clear();
		//use parent-child hierarchy in xpath.
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9999999999");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		

	}

}
