package testscript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertHandling extends Base {
	public void handlingAlerts()

	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@id='alertButton']"));
		simpleAlert.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void handlingConfirmAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
		confirmAlert.click();
		Alert a1 = driver.switchTo().alert();
		System.out.println(a1.getText());

		a1.accept();
	}

	public void handlingPromptAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement promtAlert = driver.findElement(By.xpath("//button[@id='promtButton']"));
		promtAlert.click();
		Alert a1 = driver.switchTo().alert();
		a1.sendKeys("Kanchi");
		a1.accept();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlertHandling alert = new AlertHandling();
		alert.initializeBrowser();
//alert.handlingConfirmAlert();
		alert.handlingPromptAlert();
//alert.handlingAlerts();
//alert.driverCloseAndQuit();
	}

}
