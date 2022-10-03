import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class misc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		File scrnshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Open the project's properties---> Java Build Path ---> Libraries tab ---> Add External Jars. Download CommonsIO jar and add. 
		FileUtils.copyFile(scrnshotFile, new File("C:\\Vani\\Work\\Udemy\\Selenium\\scrnShot.png"));
	}

}
