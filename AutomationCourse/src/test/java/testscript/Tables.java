package testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tables extends Base {
	public void handlingTables()
	{
		driver.navigate().to("https://money.rediff.com/indices/nse");
		WebElement showmore=driver.findElement(By.xpath("//a[@id=\'showMoreLess\']"));
		showmore.click();
		WebElement tablefield=driver.findElement(By.xpath("//table[@id='dataTable']"));
		System.out.println(tablefield.getText());
		WebElement rowprint=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[3]"));
		System.out.println(rowprint.getText());
		List<WebElement> showHeading=driver.findElements(By.xpath("//table[@id='dataTable']/thead//th"));
		for(WebElement option:showHeading)
		{
			String text=option.getText();
			System.out.println(text);
		}
	}

	public static void main(String[] args) {
		
		Tables tables=new Tables();
		tables.initializeBrowser();
		tables.handlingTables();
		tables.driverCloseAndQuit();		// TODO Auto-generated method stub

	}

}
