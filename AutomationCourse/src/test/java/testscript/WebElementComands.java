package testscript;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;

//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebElementComands extends Base{

	public void webElementCommand()
	{
			driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
			WebElement showmessagefield=driver.findElement(By.xpath("//input[@id='single-input-field']"));
			showmessagefield.sendKeys("Kanchi");
			WebElement showmessagebutton=driver.findElement(By.xpath("//button[@id='button-one']"));
			showmessagebutton.click();
			WebElement yourmessage=driver.findElement(By.xpath("//div[@id='message-one']"));
			String message=yourmessage.getText();
			System.out.println(message);
			showmessagefield.clear();
			
			
			String backgroundcolour=showmessagebutton.getCssValue("background-color");
			System.out.println(backgroundcolour);
			
			int xaxis=showmessagebutton.getLocation().getX();
			System.out.println(xaxis);
			int yaxis=showmessagebutton.getLocation().getY();
			System.out.println(yaxis);
			
			boolean isShowMessageButtonEnable=showmessagebutton.isEnabled();
			System.out.println(isShowMessageButtonEnable);
			boolean isShowMessageButtonDisplayed=showmessagebutton.isDisplayed();
			System.out.println(isShowMessageButtonDisplayed);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebElementComands webelementcommands=new WebElementComands();
webelementcommands.initializeBrowser();
webelementcommands.webElementCommand();
webelementcommands.driverCloseAndQuit();
	}

}
