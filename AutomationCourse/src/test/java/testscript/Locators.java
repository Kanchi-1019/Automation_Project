package testscript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class Locators extends Base {
	
	public void locators()
	{
	driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
	WebElement messageField=driver.findElement(By.id("single-input-field"));
	WebElement messageField1=driver.findElement(By.className("form-control"));
	WebElement showmessagebutton=driver.findElement(By.tagName("button"));
	WebElement showName=driver.findElement(By.name("description"));
	WebElement showlinkText=driver.findElement(By.linkText("Checkbox Demo"));
	WebElement showlinkText1=driver.findElement(By.partialLinkText("Checkbox "));
	WebElement cssSelector=driver.findElement(By.cssSelector("button[id='button-one']"));
	
	WebElement xpath1=driver.findElement(By.xpath("//input[@'single-input-field']"));
	WebElement showmessagebutton1=driver.findElement(By.xpath("//button[@id='button-one']"));
	driver.findElement(By.xpath("//button[contains(@id-'one')]"));
	driver.findElement(By.xpath("//button[text()='Show Message']"));//locating using text
	driver.findElement(By.xpath("//button[starts-with(text(),'Show ')]"));//using partial text if the text is large
	driver.findElement(By.xpath("//button[@type='button' and @id='button-one']"));//
	driver.findElement(By.xpath("//button[@id='button-one' or @id='button-one-electronics']"));
	//Xpath Axes Methods
	driver.findElement(By.xpath("//div[contains(text(),'Single Input Field')]//parent::div[@class='card']"));
	driver.findElement(By.xpath("//button[@id='button-one']//ancestor::div"));
	driver.findElement(By.xpath("//div[@class='card-body']//child::button[@id='button-one']"));
	driver.findElement(By.xpath("/div[@class='card-body']//ancestor::div"));
	driver.findElement(By.xpath("//button[@id='button-one']//following::div[@class='card'"));
	driver.findElement(By.xpath("//button[@id='button-one']//preceding::div[@class='card']"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Locators locator=new Locators();
locator.initializeBrowser();
locator.driverCloseAndQuit();
	}

}
