package SalesForce;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SalesForceDashboardCreateLead {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-r8']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		element.click();
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by Madhavan");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']"));
		String text = element2.getText();
		System.out.println(text);
	if(text.contains("Salesforce Automation by Madhavan")) {
		System.out.println("the given dashboard name is verified");
	}
	else
		System.out.println("the given dashboard name is not verified");
		
	}

}
