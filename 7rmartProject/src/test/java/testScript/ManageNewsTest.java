package testScript;
import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	
	
	@Test(description = "User can able to enter news on the news field of Manage News",priority=1)
		public void userCanEnterNewsOnTheNewsFieldOfManageNews() throws IOException
	{
		String username1=ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1=ExcelUtilities.getStringData(1, 1,"LoginPage");
		String enterNews=ExcelUtilities.getStringData(1, 0, "ManageNewsPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnTheManageNews();
		news.clickOnTheNewButton();
		news.enterNewsOnTheNewsField(enterNews);
		news.clickOnTheSaveButton();
		
	}

}
