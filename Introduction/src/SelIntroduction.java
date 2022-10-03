import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// Invoking Browser
		// Chrome Launch
		
		//chromedriver setpath
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Firefox launch
		//System.setProperty("webdriver.gecko.driver", "C:/Vani/Work/Udemy/Selenium/geckodriver/geckodriver.exe");
		
		//WebDriver driver = new FirefoxDriver();	
		
		//Edge launch
		//System.setProperty("webdriver.edge.driver", "C:/Vani/Work/Udemy/Selenium/edgedriver/msedgedriver.exe");
		
		//WebDriver driver = new EdgeDriver();	
		
		driver.get("https://www.grubhub.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		driver.quit();

	}

}