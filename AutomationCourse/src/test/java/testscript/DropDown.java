package testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends Base{
	
	public void handlingdropdow()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropdown1=driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
		Select select=new Select(dropdown1);
		select.selectByIndex(1);
		WebElement dropdown2=driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']"));
		Select select1=new Select(dropdown2);
		select1.selectByVisibleText("Maven");
		WebElement dropdown3=driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']"));
		Select select2=new Select(dropdown3);
		select2.selectByValue("javascript");
		
	}
	public void handlingcheckbox()
	{
		driver.navigate().to("https://selenium.qabible.in/check-box-demo.php");
	 WebElement checkbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
	 checkbox.click();
	}
	public void handlingListCheckBox()
	{
		driver.navigate().to("https://selenium.qabible.in/check-box-demo.php");
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='check-box-list']"));
		
		for(WebElement check:checkbox)
		{
			check.click();
		}
	}
	public void handlingRadioButton()
	{
		driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
		 WebElement radiobutton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));	
		 radiobutton.click();
		 boolean isRadioButtonSelected=radiobutton.isSelected();
		 System.out.println(isRadioButtonSelected);
	}

	public static void main(String[] args) {
	// TODO Auto-generated method stub
DropDown dropdown=new DropDown();
dropdown.initializeBrowser();
//dropdown.handlingcheckbox();
//dropdown.handlingdropdow();
dropdown.handlingRadioButton();
//dropdown.driverCloseAndQuit();
//dropdown.handlingListCheckBox();
	}

}
