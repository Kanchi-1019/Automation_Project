package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.getText();
	}
	public void selectDropDownWithIndexValue(WebElement element, int index)
	{
		Select object = new Select(element);
		object.selectByIndex(index);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.getText();
	}
	public void selectDropDownWithVisibleText(WebElement element,String text)
	{
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.getText();
	}
	public void handlingMouseActionRightClick(WebElement element)
	{
		
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public void handlingMouseOver(WebElement element)
	{
		
		Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
	}
	public void handlingDragAndDrop(WebElement dragable,WebElement dropArea) {
		Actions action=new Actions(driver);
		action.dragAndDrop(dragable, dropArea).build().perform();
}
	public void javaScriptExecutorScroll(WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		
	}
	public void javaScriptExecutorClick()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)","");
	}
}
