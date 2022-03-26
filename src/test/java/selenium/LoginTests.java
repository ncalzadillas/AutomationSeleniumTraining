package selenium;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangeHRM.Leave;
import orangeHRM.Login;
import orangeHRM.Menu;

@Listeners(utility.Listener.class)
public class LoginTests {
	
	private WebDriver driver;
	Login login;
	Menu menu;
	Leave leave;
	String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	String usuario = "Admin";
	String password = "admin123";
	String incorrectUsuario = "Test";
	String incorrectPassword = "Test123";
	
	@Parameters(value= {"browser"})
	@BeforeTest
	public void initTest(ITestContext context, @Optional("chrome") String browser) {
		login = new Login(driver);
		driver = login.openBrowser(browser, context);
		login.openUrl(url);
	}
	
	@Test(enabled = true, priority=2)
	public void accederCorrectamente() {
		login.loginSuccess(usuario, password);
		login.logout();
	}
	
	@Test(enabled = true, priority=1)
	public void wrongPassword() {
		login.loginError(incorrectUsuario, incorrectPassword, "Invalid credentials");
		login.loginError("", password, "Username cannot be empty");
		login.loginError(usuario, "", "Password cannot be empty");
	}
	
	@Test(enabled = true, priority=3)
	public void pedirVacaciones() {
		login.loginSuccess(usuario, password);
		menu = new Menu(driver);
		menu.selectMenuSubMenu("Leave",  "Assign Leave");
		leave = new Leave(driver);
		leave.requestVacationFullDay("Odis Adalwin", "2022-03-31", "2022-04-10", "US - Vacation");
		login.logout();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
