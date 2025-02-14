package testScript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	
	@Test(description = "User can able to enter news on the news field of Manage News",priority=1)
		public void userCanEnterNewsOnTheNewsFieldOfManageNews() throws IOException
	{
		String username1=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1=ExcelUtility.getStringData(1, 1,"LoginPage");
		String enterNews=ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnTheManageNews();
		news.clickOnTheNewButton();
		news.enterNewsOnTheNewsField(enterNews);
		news.clickOnTheSaveButton();
		boolean isAlertDisplayed=news.alertForNewMsgAdd();
		Assert.assertTrue(isAlertDisplayed,Messages.ERRORMESSAGEFORADDNEWS);
		
	}

}
