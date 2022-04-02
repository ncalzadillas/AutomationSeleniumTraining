package utility;

import org.openqa.selenium.WebDriver;

import orangeHRM.Leave;
import orangeHRM.Login;
import orangeHRM.LoginPageFactory;
import orangeHRM.Menu;

public class Instances {
	WebDriver driver;
	Leave leave;
	Login login;
	Menu menu;
	Base base;
	LoginPageFactory loginFac;
	/**
	 * @param driver
	 */
	public Instances(WebDriver driver) {
		this.driver = driver;
		login = new Login(driver);
		leave = new Leave(driver);
		menu = new Menu(driver);
		base = new Base(driver);
		loginFac = new LoginPageFactory(driver);
	}
	
	public Instances() {
		base = new Base(driver);
	}

	/**
	 * @return the leave
	 */
	public Leave getLeave() {
		return leave;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @return the base
	 */
	public Base getBase() {
		return base;
	}
	
	public LoginPageFactory getLoginFac() {
		return loginFac;
	}


}
