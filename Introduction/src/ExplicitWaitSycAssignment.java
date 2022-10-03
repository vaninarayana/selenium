import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSycAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Vani/Work/Udemy/Selenium/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:/Vani/Work/Udemy/Selenium/extension_4_4_5_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String userName = "rahulshettyacademy";
		String passWord = "learning";

		// login into the cart
		completeLogin(driver, expWait, userName, passWord);

		// explicit wait for products page to load
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card-footer")));

		// add all products on page to Cart
		addToCart(driver);

		// checkout
		driver.findElement(By.cssSelector("a.btn-primary")).click();

	}

	public static void completeLogin(WebDriver driver, WebDriverWait expWait, String userName, String passWord) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);

		// select usertype User
		driver.findElement(By.xpath("(//input[@id='usertype'])[2]")).click();

		// explicit wait for confirm window to pop up
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
		driver.findElement(By.id("okayBtn")).click();

		// Select 'Consultant' from dropdown
		WebElement staticdropdown = driver.findElement(By.cssSelector("select.form-control"));

		Select dropdown = new Select(staticdropdown);

		dropdown.selectByValue("consult");

		// check terms checkbox and click sign-in
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

	public static void addToCart(WebDriver driver) {

		int i;

		// get all the products on the page
		List<WebElement> products = driver.findElements(By.cssSelector("div.h-100"));

		// loop through all the products and add to cart
		for (i = 0; i < products.size(); i++) {
			driver.findElements(By.cssSelector("button.btn-info")).get(i).click();

		}
	}

}
