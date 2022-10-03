import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamsWebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//check if the product name column sorts on clicking

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column header
		driver.findElement(By.xpath("//th[1]")).click();
		
		//get the first column elements in a List
		List<WebElement> colData = driver.findElements(By.xpath("//td[1]"));
		
		//Get product names from the list into a String List
		List<String> origList = colData.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sort the above list and save in another List
		List<String> sortedList = origList.stream().sorted().collect(Collectors.toList());
		
		//compare the 2 lists to check if they match, if not, fail the test
		Assert.assertTrue(origList.equals(sortedList),"Test Failed. Column NOT SORTED!!");	
		
		List<String> prodPrice; int pageCount = 0;
		
		//paginate and find a product price
		do{
			pageCount++;
		
			List<WebElement> colPageData = driver.findElements(By.xpath("//td[1]"));
			prodPrice = colPageData.stream().filter(s -> s.getText().contains("Mango")).map(s -> getProdPrice(s))
					.collect(Collectors.toList());

			//print the price of the product
			prodPrice.forEach(s -> System.out.println(s));

			//if product not found, click 'Next' to go to the next page
			if (prodPrice.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

		} while (prodPrice.size() < 1); //repeat loop if product not found
		System.out.println("Found on page number: "+pageCount);
	}
	
	public static String getProdPrice(WebElement tdEle) {
		
		return tdEle.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
