package testscript;

public class BrowserCommands extends Base {
	public void navigationCommand()
	{
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	public void browserCommand()
	{
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String title=driver.getTitle();
		System.out.println(title);
		String windowhandles = driver.getWindowHandle();
		System.out.println(windowhandles);;
		String pagesourse=driver.getPageSource();
		System.out.println(pagesourse);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BrowserCommands browsercommads=new BrowserCommands();
browsercommads.initializeBrowser();
browsercommads.navigationCommand();
browsercommads.browserCommand();
//browsercommads.driverCloseAndQuit();

	}

}
