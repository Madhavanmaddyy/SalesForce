package SalesForce;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class EditOpportunities {
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
	driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by madhavan",Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	WebElement element = driver.findElement(By.xpath("//input[@name='Name']"));
	element.clear();
	element.sendKeys("SalesForce Automated by madhavan");
	WebElement ele = driver.findElement(By.xpath("//input[@name='CloseDate']"));
	ele.clear();
	ele.sendKeys("05/04/2023",Keys.ENTER);
	driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[2]")).click();
    driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
    WebElement ele3 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
    driver.executeScript("arguments[0].click();", ele3); 
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[text()='In progress'])[1]")).click();
    driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Sales Force");
    driver.findElement(By.xpath("//button[text()='Save']")).click();
    Thread.sleep(5000);
    WebElement ele4 = driver.findElement(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink slds')]"));
    String text1 = ele4.getText();
    String text2 = "SalesForce Automated by madhavan";
    boolean b = text1.equals(text2);
    System.out.println(b);
    
	}


	

}
