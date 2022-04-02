package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.DataTest;
import orangeHRM.Leave;
import orangeHRM.Login;
import orangeHRM.Menu;

public class LoginTestDataProvider {
	
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
	
	@Test(enabled = true, priority=1, dataProvider="loginFallidos", dataProviderClass=DataTest.class)
	public void wrongPassword(String usuario, String password, String errorMessage) {
		login.loginError(usuario, password, errorMessage);
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
	
	/*
	 * @DataProvider(name="loginFallidos") public Object[][] getUsers(){ Object[][]
	 * data = new Object[3][3];
	 * 
	 * data[0][0] = "sergio"; data[0][1] = "1234"; data[0][2] =
	 * "Invalid credentials";
	 * 
	 * data[1][0] = ""; data[1][1] = "admin123"; data[1][2] =
	 * "Username cannot be empty";
	 * 
	 * data[2][0] = "Admin"; data[2][1] = ""; data[2][2] =
	 * "Password cannot be empty";
	 * 
	 * return data; }
	 */
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
