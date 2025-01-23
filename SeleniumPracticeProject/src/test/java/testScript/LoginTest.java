package testScript;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import automationCore.Base;

public class LoginTest extends Base {
	@Test(description = "Login Using Valid Credentials")
	public void userLoginWithValidUsernameAndValidPassword()
	{
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	@Test(description = "Login Using Invalid Credentials")
	public void userLoginWithInvalidUsernameAndInvalidPassword()
	{
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("obsqura");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("obsqura");
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	@Test(description = "Login using valid username and invalid password")
	public void userLoginWithValidUsernamrAndInvalidPassword()
	{WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
	username.sendKeys("standard_user");
	WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys("obsqura");
	WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
	loginButton.click();
	}
	@Test(description = "Login using invalid username and valid password")
	public void userLoginWithInvalidUsernameAndValidPassword()
	{
		
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("obsqurs");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
		
		loginButton.click();
	}

}
