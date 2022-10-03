import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		
		List<WebElement> tbCols = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		
		//print number of rows and columns in the table
		System.out.println("Number of Rows: "+tbRows.size());
		System.out.println("Number of Columns: "+tbCols.size());
		
		//get the second Row data and print		
		WebElement secRowDriver = tbRows.get(2);
		
		List<WebElement> secRow = secRowDriver.findElements(By.xpath("td"));
		
		for(int i=0;i<secRow.size();i++)
		{
			System.out.println("Row 2 - Column "+(i+1)+" : "+secRow.get(i).getText());
		}
	}

}
