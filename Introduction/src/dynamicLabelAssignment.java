import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dynamicLabelAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");
			
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));		
		
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String chkboxLabel="";
		
		//select checkbox Option1
		driver.findElement(By.id("checkBoxOption1")).click();
		
		//if Option1 selected, grab label into a variable
		if(driver.findElement(By.id("checkBoxOption1")).isSelected())
		{
			//chkboxLabel  = driver.findElement(By.xpath("//label[@for='bmw']")).getText(); 
			chkboxLabel = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText(); 
		}
		
		//select the same Option1 from static dropdown. Using chkboxLabel variable
		WebElement dropdownElem = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(dropdownElem);
		
		dropdown.selectByVisibleText(chkboxLabel);
		
		//Enter same label into Name field and click Alert button
		driver.findElement(By.id("name")).sendKeys(chkboxLabel);
		driver.findElement(By.id("alertbtn")).click();
		
		//Get alert window text
		String alertText = driver.switchTo().alert().getText();
		
		////if the text matches with the checkbox label, its a success!
		if(alertText.contains(chkboxLabel))
		{
			System.out.println("YES!! Its a match! \n"+alertText);
		}
		else
		{
			System.out.println("NOPE!! Not a match! ");
		}

	}

}
