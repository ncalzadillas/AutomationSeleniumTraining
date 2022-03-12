package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PrimerScript {
	
	WebDriver driver;
	String OSName = System.getProperty("os.name");
	String projectPath = System.getProperty("user.dir");
	String chromeDriver;
	String edgeDriver;
	String geckoDriver;
	
	@Test
	public void primerScriptSelenium() {
		
		driver = openBrowser("chrome");
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//ChromeDriver//chromedriver");
		//ChromeOptions option = new ChromeOptions();
		//option.addArguments("--start-maximized");
		//option.addArguments("--incognito");
		
		//WebDriver driver = new ChromeDriver(option);
		
		String useNameString = "Admin";
		String passwordString = "admin123";
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		
		Reporter.log("El Usuario que ingresaste es Admin",true);
		userName.sendKeys(useNameString);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		Reporter.log("El Usuario que ingresaste es admin123",true);
		password.sendKeys(passwordString);
		
		WebElement login = driver.findElement(By.cssSelector("#btnLogin"));
		login.click();
		
	}
	
	@Test
	public void segundoScriptSelenium() {
		
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//EdgeDriver//msedgedriver");
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		
		WebDriver driver = new EdgeDriver(option);
		
		String useNameString = "Admin";
		String passwordString = "admin123";
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		
		Reporter.log("El Usuario que ingresaste es Admin",true);
		userName.sendKeys(useNameString);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		Reporter.log("El Usuario que ingresaste es admin123",true);
		password.sendKeys(passwordString);
		
		WebElement login = driver.findElement(By.cssSelector("#btnLogin"));
		login.click();
	}

	public WebDriver chromeDriverConnection() {
		
		setDriverPaths();
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
		
	}
	
	public WebDriver geckoDriverConnection() {
		
		setDriverPaths();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new FirefoxDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
		
	}
	
	public WebDriver edgeDriverConnection() {
		
		setDriverPaths();
		System.setProperty("webdriver.edge.driver", edgeDriver);
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new EdgeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
		
	}
	
	public String getOSName() {
		
		if(OSName.contains("Windows")) {
			OSName="Windows";
		}else if(OSName.contains("Mac")) {
			OSName = "Mac";
		}else if(OSName.contains("Linux")) {
			OSName = "Linux";
		}
	
		return OSName;
	}
	
	public void setDriverPaths() {
		OSName = getOSName();
		switch(OSName) {
		case "Linux":
		case "Mac":
			chromeDriver = projectPath + "//ChromeDriver//chromedriver";
			edgeDriver = projectPath + "//EdgeDriver//msedgedriver";
			geckoDriver = projectPath + "//GekoDriver//geckodriver";
			break;
		case "Windows":
			chromeDriver = projectPath + "\\ChromeDriver\\chromedriver";
			edgeDriver = projectPath + "\\EdgeDriver\\msedgedriver";
			geckoDriver = projectPath + "\\GekoDriver\\geckodriver";
			break;
		}
		
	}
	
	public WebDriver openBrowser(String browserName) {
		
		switch(browserName) {
		case "chrome":
			driver = chromeDriverConnection();
			break;
		case "edge":
			driver = edgeDriverConnection();
			break;
		case "firefox":
			driver = geckoDriverConnection();
			break;
			default:
				Reporter.log("Driver can't be initialized. Browser is: + browserName: ", true);
		}
		
		return driver;
	}
}
