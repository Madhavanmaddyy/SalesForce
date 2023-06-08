package SalesForce;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOpportunities {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("Start-Maximized","--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-r6']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", ele2);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@name='Name']"));
		ele.sendKeys("Salesforce Automation by madhavan");
		String text = ele.getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("3/30/2023");
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}

}
