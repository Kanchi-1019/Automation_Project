package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass extends Base {
	public void handlingMouseAction()
	{
		driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclick=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action=new Actions(driver);//predefined class-Actions
		action.contextClick(rightclick).build().perform();
	
		
	}
	public void handlingMouseOver()
	{
		driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
		WebElement mouseover=driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
		Actions action=new Actions(driver);
	action.moveToElement(mouseover).build().perform();
	}
	public void handlingDragAndDrop() {
		driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
		WebElement dragable=driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		Actions action=new Actions(driver);
		WebElement dropArea=driver.findElement(By.xpath("//div[@id='mydropzone']"));
		action.dragAndDrop(dragable, dropArea).build().perform();
		
	}
	
	
	public void keyBoardActions() throws AWTException
	{
		//driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public static void main(String[] args)  
	{
		
		ActionsClass action=new ActionsClass();
		action.initializeBrowser();
		//action.handlingMouseAction();
		//action.handlingMouseOver();
		//action.handlingDragAndDrop();
		try {
			action.keyBoardActions();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//action.driverCloseAndQuit();
		// TODO Auto-generated method stub

	}

}
