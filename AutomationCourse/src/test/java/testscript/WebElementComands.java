package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementComands extends Base{

	public void webElementCommands()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
	WebElement showmessagefield=driver.findElement(By.xpath("//input[@id='single-input-field']"));
			showmessagefield.sendKeys("Kanchi");
			WebElement showmessagebutton=driver.findElement(By.xpath("//button[@id='button-one']"));//button[@id='button-one']));
			showmessagebutton.click();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebElementComands webelementcommands=new WebElementComands();
webelementcommands.initializeBrowser();
webelementcommands.webElementCommands();
//webelementcommands.driverCloseAndQuit();
	}

}
