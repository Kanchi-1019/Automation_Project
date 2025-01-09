package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementCommandsInputForm extends Base{
	public void webElementCommands()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement message=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		message.sendKeys("Kanchi");
		WebElement messagebutton=driver.findElement(By.xpath("//button[@id='button-one']"));
		messagebutton.click();
		WebElement messagefield=driver.findElement(By.xpath("//input[@id='value-a']"));
		messagefield.sendKeys("25");
		WebElement messagefield1=driver.findElement(By.xpath("//input[@id='value-b']"));
		messagefield1.sendKeys("36");
		WebElement totalbutton=driver.findElement(By.xpath("//button[@id='button-two']"));
		totalbutton.click();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebElementCommandsInputForm commands=new WebElementCommandsInputForm();
commands.initializeBrowser();
commands.webElementCommands();
//commands.driverCloseAndQuit();
	}

}
