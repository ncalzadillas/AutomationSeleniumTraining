package selenium;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.DataTest;
import utility.Base;

@Listeners({utility.Listener.class})
public class ValidarLinks {
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	
	@Parameters(value= {"browser"})
	@BeforeTest(groups= {"Smoke"})
	public void initTest(ITestContext context,@Optional("chrome") String browser) {
		Base.page.getBase().openBrowser(browser, context);
		Base.page.getBase().openUrl(url);
	}
	
	@Test(dataProvider="user", dataProviderClass = DataTest.class)
	public void validarLinsEnHRM(String user, String password) {
		Base.page.getLogin().loginSuccess(user, password);
		Base.page.getMenu().verifyPageLinks();
		Base.page.getLogin().logout();
	}
	
	@AfterTest
	public void endTest() {
		Base.page.getBase().closeBrowser();
	}

}
