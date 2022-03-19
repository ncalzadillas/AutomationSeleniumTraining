package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import orangeHRM.Login;

@Listeners(utility.Listener.class)
public class LoginTests {
	
	private WebDriver driver;
	Login login;
	String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	String usuario = "Admin";
	String password = "admin123";
	
	@BeforeTest
	public void initTest(ITestContext context) {
		login = new Login(driver);
		driver = login.openBrowser("chrome", context);
		login.openUrl(url);
	}
	
	@Test
	public void accederCorrectamente() {
		login.loginSuccess(usuario, password);
	}

}
