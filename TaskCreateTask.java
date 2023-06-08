package SalesForce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskCreateTask {
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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Tasks']"));
		Actions action=new Actions(driver);
		action.scrollToElement(element).perform();
		element.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--')]")).click();
	   // By xpath = By.xpath("//div[text()='New Task']");
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
		WebElement element3 = driver.findElement(By.xpath("//div[text()='New Task']"));
		driver.executeScript("arguments[0].click();",element3);
        Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		//WebElement element2 = driver.findElement(By.xpath("(//div[@class='tooltip advanced-wrapper forceHeaderButton header-tooltip south uiTooltipAdvanced'])[1]"));
	//	String text1 = element2.getText();
		//System.out.println(text1);
		
	}

}
