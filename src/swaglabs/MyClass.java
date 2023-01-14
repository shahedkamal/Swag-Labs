package swaglabs;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String myTitle = driver.getTitle();
		System.out.println(myTitle);

		List<WebElement> MyList = driver.findElements(By.className("btn"));

		for (int i = 0; i < MyList.size(); i++) {
			MyList.get(i).click();

		}

		// remove my items:

//		Thread.sleep(3000);
//		List<WebElement> RemoveMyItems = driver.findElements(By.className("btn"));
//				
//
//				for (int i = 0; i < RemoveMyItems.size(); i++) {
//					RemoveMyItems.get(i).click();
//
//				}

		driver.navigate().to("https://www.saucedemo.com/cart.html");

		String numberOfItems = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();

		int theEditednumberofItems = Integer.parseInt(numberOfItems);

		if (theEditednumberofItems == MyList.size()) {

		System.out.println("test case is passed");
		} else {
		System.out.println("faield ");
		}
         
		// assertEquals(theEditednumberofItems, MyList.size());
		
		System.out.println(theEditednumberofItems);

	}

}
