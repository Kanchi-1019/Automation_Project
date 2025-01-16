package testscript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWindowHandling extends Base {
	public void windowHandling() {
		driver.navigate().to("https://demo.guru99.com/popup.php");
		String firstWindowhandle = driver.getWindowHandle();
		System.out.println(firstWindowhandle);
		WebElement clickbutton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickbutton.click();
		Set<String> handleids = driver.getWindowHandles();
		System.out.println(handleids);
		Iterator<String> it = handleids.iterator();
		while (it.hasNext()) {
			String currentid = it.next();
			if (!currentid.equals(firstWindowhandle)) {
				driver.switchTo().window(currentid);
				WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("kanchi1817@gmail.com");
				WebElement sumbit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
				sumbit.click();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipleWindowHandling window = new MultipleWindowHandling();
		window.initializeBrowser();
		window.windowHandling();
//window.driverCloseAndQuit();
	}

}
