package SalesForce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForceCertificate {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("Start-Maximized","--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> ele = driver.getWindowHandles();
		List<String> hand=new ArrayList<String>(ele);
		driver.switchTo().window(hand.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        Shadow shadow=new Shadow(driver);
        shadow.setImplicitWait(10);
        shadow.findElementByXPath("//span[text()='Learning']").click();
        WebElement element = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
        Actions builder=new Actions(driver);
        builder.pause(20).moveToElement(element).perform();
        shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        for (int i = 0; i < elements.size(); i++) {
        	
        
			System.out.println(elements.get(i).getText());
		}
        String title = driver.getTitle();
        System.out.println("The title is "+title);
        driver.findElement(By.xpath("//a[text()='Administrator']")).click();
        if(driver.getTitle().contains("Administrator Overview")) {
        	System.out.println("the title is matched");
        	
        }
        else {
        	System.out.println("the title is didn't match");
        }
     
	}

}

