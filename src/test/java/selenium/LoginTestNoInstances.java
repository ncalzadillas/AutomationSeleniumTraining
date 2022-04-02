package selenium;

import javax.xml.crypto.Data;

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
public class LoginTestNoInstances {
	
	String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@Parameters(value= {"browser"})
	@BeforeTest(groups = {"smoke", "regression", "vacaciones"})
	public void initTest(ITestContext context, @Optional("chrome") String browser) {
		Base.page.getBase().openBrowser(browser, context);
		Base.page.getBase().openUrl(url);
	}
	
	@Test(enabled=true, priority=1, dataProvider="users",dataProviderClass = DataTest.class, groups= {"smoke", "regression"})
	public void loginCorrecto(String usuario, String password) {
		Base.page.getLogin().loginSuccess(usuario, password);
		Base.page.getLogin().logout();
	}
	
	@Test(enabled=true, priority=2, dataProvider="fechas",dataProviderClass = DataTest.class, groups= {"vacaciones", "regression"})
	public void pedirVacaciones(String fromDate, String toDate) {
		Base.page.getLogin().loginSuccess("Admin", "admin123");
		Base.page.getMenu().selectMenuSubMenu("Leave", "Assign Leave");
		Base.page.getLeave().requestVacationFullDay("Linda Jane Anderson", fromDate, toDate, "US - Vacation");
		Base.page.getLogin().logout();
	}
	
	@Test(enabled = true, priority=1, dataProvider="loginFallidos", dataProviderClass=DataTest.class, groups= {"regression"})
	public void wrongPassword(String usuario, String password, String errorMessage) {
		Base.page.getLogin().loginError(usuario, password, errorMessage);
	}
	
	@Test(enabled = true, priority=3, dataProvider="users", dataProviderClass=DataTest.class, groups= {"regression"})
	public void loginPorPageFactory(String usuario, String password) {
		Base.page.getLoginFac().loginSuccessPageFactory(usuario, password);
		Base.page.getLoginFac().logout();
	}
	
	@Test(enabled = true, priority=4, dataProvider="usersJSON", dataProviderClass=DataTest.class, groups= {"regression"})
	public void loginJSONUser(String usuario, String password) {
		Base.page.getLoginFac().loginSuccessPageFactory(usuario, password);
		Base.page.getLoginFac().logout();
	}
	
	@Test(enabled = true, priority=1, dataProvider="loginFallidosJSON", dataProviderClass=DataTest.class, groups= {"regression"})
	public void wrongPasswordJSON(String usuario, String password, String errorMessage) {
		Base.page.getLogin().loginError(usuario, password, errorMessage);
	}
	
	@AfterTest(groups = {"smoke", "regression", "vacaciones"})
	public void close() {
		Base.page.getBase().closeBrowser();
	}

}
