package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor extends Base{
	public void javaScriptExecutorSample()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;//cast to driver
		js.executeScript("arguments[0].click90;",showMessageButton);
		js.executeScript("window.scrollBy(0,350)","");
		//js.executeScript("window.scrollBy(0,-350)","");
	}

	public static void main(String[] args) {
		JavaScriptExecutor executor=new JavaScriptExecutor();
		executor.initializeBrowser();// TODO Auto-generated method stub
executor.javaScriptExecutorSample();
//executor.driverCloseAndQuit();
	}

}
