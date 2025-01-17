package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUpload extends Base {
	public void fileUploadUsingsendKeys() {
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		fileUpload.sendKeys(
				"C:\\Users\\Kanchi\\git\\Automation_Project\\AutomationCourse\\src\\test\\resources\\ECLIPSEGIT[1].pdf");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='terms']"));
		checkbox.click();
		WebElement submitbutton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitbutton.click();
	}

	public void fileUploadingRobotClass() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement fileUpload = driver.findElement(By.xpath("//a[@id='pickfiles']"));
		fileUpload.click();
		StringSelection s = new StringSelection(
				"C:\\Users\\Kanchi\\git\\Automation_Project\\AutomationCourse\\src\\test\\resources\\ECLIPSEGIT[1].pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
		robot.delay(2500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUpload upload = new FileUpload();
		upload.initializeBrowser();
//upload.fileUploadUsingsendKeys();
		try {
			upload.fileUploadingRobotClass();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
