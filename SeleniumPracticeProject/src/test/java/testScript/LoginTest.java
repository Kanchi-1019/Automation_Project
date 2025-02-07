package testScript;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;

public class LoginTest extends Base {
	@Test(description = "Login Using Valid Credentials", priority = 1,groups = {"smoke"})
	public void userLoginWithValidUsernameAndValidPassword() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		boolean isLoginButtonDisplayed = loginButton.isDisplayed();
		loginButton.click();
		 Assert.assertTrue(isLoginButtonDisplayed, "Login button is not displayed");
		WebElement heading = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		String actual = heading.getText();
		String expected = "Swag Labs";
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Login Using Invalid Credentials", priority = 2,groups = {"smoke"})
	public void userLoginWithInvalidUsernameAndInvalidPassword() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("obsqura");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("obsqura");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	
		
		loginButton.click();
		boolean isLoginButtonDisplayed = loginButton.isDisplayed();
		Assert.assertTrue(isLoginButtonDisplayed, "Login button is not displayed");
		
	}
	@Test(description = "Login using valid username and invalid password", priority = 3)
	public void userLoginWithValidUsernamrAndInvalidPassword() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("obsqura");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		boolean isLoginbuttonDisplayed = loginButton.isDisplayed();
		loginButton.click();
		Assert.assertTrue(isLoginbuttonDisplayed, "Login Button is not Displayed");
	}

	@Test(description = "Login using invalid username and valid password", priority = 4)
	public void userLoginWithInvalidUsernameAndValidPassword() {

		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("obsqurs");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		boolean isloginBottonDisplayed = loginButton.isDisplayed();
		loginButton.click();
		Assert.assertTrue(isloginBottonDisplayed, "Login Button is displayed");
	}

}
