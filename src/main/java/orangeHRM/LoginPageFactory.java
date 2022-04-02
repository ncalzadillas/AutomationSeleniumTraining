package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Base;

public class LoginPageFactory extends Base{
	WebDriver driver;
	
	/*
	 * By txt_userName = By.id("txtUsername"); By txt_password =
	 * By.xpath("//input[@id='txtPassword']"); By btn_login =
	 * By.cssSelector("#btnLogin"); By text_errorMessage = By.id("spanMessage"); By
	 * link_forgotPassword = By.linkText("Forgot your password?"); By
	 * txt_orangeHRMuserName = By.id("securityAuthentication_userName"); By
	 * btn_resetPassword = By.id("btnSearchValues"); By btn_cancel =
	 * By.id("btnCancel"); By text_errorResetPassword =
	 * By.className("message.warning.fadable"); By text_successResetPassword =
	 * By.xpath("//*[@id='divContent']/p"); By link_welcome = By.id("welcome"); By
	 * link_logout = By.xpath("//*[contains(@href,'logout')]");
	 */
	
	@FindBy(id="txtUsername")
	WebElement txt_userName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement txt_password;
	
	@FindBy(css="#btnLogin")
	WebElement btn_login;
	
	@FindBy(id = "welcome")
	WebElement link_welcome;
	
	@FindBy(xpath="//*[contains(@href,'logout')]")
	WebElement link_logout;
	
	public LoginPageFactory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginSuccessPageFactory(String user, String password) {
		type(user,txt_userName);
		type(password, txt_password);
		click(btn_login);
		verifyElementIsPresent(link_welcome);
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
