package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Base;

public class Login extends Base{
	
	By txt_userName = By.id("txtUsername");
	By txt_password = By.xpath("//input[@id='txtPassword']");
	By btn_login = By.cssSelector("#btnLogin");
	By text_errorMessage = By.id("spanMessage");
	By link_forgotPassword = By.linkText("Forgot your password?");
	By txt_orangeHRMuserName = By.id("securityAuthentication_userName");
	By btn_resetPassword = By.id("btnSearchValues");
	By btn_cancel = By.id("btnCancel");
	By text_errorResetPassword = By.className("message.warning.fadable");
	By text_successResetPassword = By.xpath("//*[@id='divContent']/p");
	By link_welcome = By.id("welcome");
	By link_logout = By.xpath("//*[contains(@href,'logout')]");
	
	//Please contact HR admin in order to reset the password
	//There is a password reset request already in the system.   
    
	
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	public void loginSuccess(String user, String password) {
		type(user,txt_userName);
		type(password, txt_password);
		click(btn_login);
		verifyElementIsPresent(link_welcome);
		takeScreenShot();
		
	}
	
	public void loginError(String user, String password, String errorMessage) {
		type(user,txt_userName);
		type(password, txt_password);
		click(btn_login);
		verifyElementIsPresent(text_errorMessage);
		validateExpectedText(errorMessage, getText(text_errorMessage));
		takeScreenShot();
		
	}
	
	public void logout() {
		verifyElementIsPresent(link_welcome);
		click(link_welcome);
		verifyElementIsPresent(link_logout);
		takeScreenShot();
		click(link_logout);
		verifyElementIsPresent(txt_userName);
	}

}
