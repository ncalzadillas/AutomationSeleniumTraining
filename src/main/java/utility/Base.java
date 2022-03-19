package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;

public class Base {
	
	private WebDriver driver;
	private String OSName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private String chromeDriver;
	private String edgeDriver;
	private String geckoDriver;
	
	/**
	 * @Description Constructor sin parametros
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public Base() {
		
	}
	
	/**
	 * @Description Constructor con un parametro
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param WebDriver
	 * @return N/A
	 */
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @Description Lama el metodo para hacer set al web Driver
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param WebDriver
	 * @return N/A
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @Description get Web Driver
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * @Description Inicializa y configura el Chrome Driver
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
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
	
	/**
	 * @Description Inicializa y configura el FireFox Driver
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
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
	
	/**
	 * @Description Inicializa y configura el Edge Driver
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
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
	
	/**
	 * @Description Constructor con dos parametros
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
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
	
	/**
	 * @Description Constructor con dos parametros
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
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
		default:
			Reporter.log("El path no esta inicializado", true);
		}
	}
	
	/**
	 * @Description Constructor con dos parametros
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public WebDriver openBrowser(String browserName, ITestContext context) {
		
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
		
		context.setAttribute("WebDriver",driver);
		return driver;
	}
	
	/**
	 * @Description Escribir texto en web element por locator
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param locator
	 * @return N/A
	 */
	public WebElement findElement(By locator) {
		Reporter.log("Localizar Element", true);
		return driver.findElement(locator);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public String getText(By locator) {
		String text = findElement(locator).getText();
		reporter("El texto obtenido es: ",text);
		return text;
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public void click(By locator) {
		Reporter.log("web Element was clicked");
		findElement(locator).click();
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public void reporter(String message, String value) {
		Reporter.log(message + "<b> [ " + value + "] </b>", true);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public void type(String inputText, By locator) {
		findElement(locator).clear();
		findElement(locator).sendKeys(inputText);
		reporter("Fue ingresado",inputText);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public void verifyElementIsPresent(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		reporter("El elemento existe","");
	}
	
	/**
	 * @Description Abre el URL en una ventana nueva
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param String
	 * @return N/A
	 */
	public void openUrl(String url) {
		driver.get(url);
		reporter("El URL fue abierto: ", url);
	}
	
	public void navigateToURL(String url) {
		driver.navigate().to(url);
		reporter("El URL fue abierto: ", url);
	}
	
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public void takeScreenShot() {
		OSName = getOSName();
		String path = "";
		switch(OSName) {
		case"Mac":
		case "Linux":
			path = projectPath + "/execution_results/screenshots/";
			//projectPath = ".//execution_results//screenshots//";
			break;
		case "Widnwos":
			path = projectPath + "\\execution_results\\screenshots\\";
			//projectPath = ".//execution_results//screenshots//";
			break;
		}
	
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			String fullPath = path + "Screen"+formater.format(calendar.getTime())+".png";
			FileUtils.copyFile(srcFile, new File(fullPath));
			//fullPath = "." + fullPath;
			Reporter.log("*******El screenshot fue guardado en: " + fullPath+"***********", true);
			Reporter.log("<br> <img src='"+ fullPath +"'height='400' width='400'/></br>",true);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}

}
