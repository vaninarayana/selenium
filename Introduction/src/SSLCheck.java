import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		// FirefoxOptions , EdgeOptions, SafariOptions etc
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));
		
		//add this to bypass bad ssl
		options.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
