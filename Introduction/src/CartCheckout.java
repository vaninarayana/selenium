import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartCheckout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//implicit wait . Commenting it out to use Explicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//List of products to be added to the cart
		String[] vegNames = {"Cauliflower","Potato","Tomato","Musk Melon"};
		
		//explicit wait declaration
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
		
		//3sec delay for the page to load
		Thread.sleep(3000);
		
		addToCart(driver, vegNames);
		
		//proceed to checkout page
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//explicit wait for promocode input to load
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		
		//enter promocode
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait for promoInfo to load
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		//get promo code success msg
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		

	}
	
	public static void addToCart(WebDriver driver, String[] vegNames) {
		
		int i;
		int prodCount = 0;
		
		//get all the products on the page
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//loop through all the products to find a match with vegNames
		for(i=0;i<products.size();i++)
		{
			//product names are listed as 'Cucumber - 1 Kg'. Needs split and trim.
			
			String[] prodNameArr = products.get(i).getText().split("-");
			String prodName = prodNameArr[0].trim();			
			
			//convert array to arraylist at runtime. Saves memory
			List vegList = Arrays.asList(vegNames);
			
			if(vegList.contains(prodName))
			{
				prodCount++;
				
				//if prodName matches vegList, click 'Add to Cart'
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				//if everything on vegList is selected, break out of loop
				
				if(prodCount==vegNames.length)
					break;
			}
		}		
	}

}
