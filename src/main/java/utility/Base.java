package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Base {
	
	private WebDriver driver;
	private String OSName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private String chromeDriver;
	private String edgeDriver;
	private String geckoDriver;
	public static Instances page = new Instances();
	
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
		
		page = new Instances(driver);
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
	public String getText(WebElement element) {
		String text = element.getText();
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
	public void click(WebElement element) {
		Reporter.log("web Element was clicked");
		element.click();
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param String, String
	 * @return N/A
	 */
	public void reporter(String message, String value) {
		Reporter.log(message + "<b> [ " + value + "] </b>", true);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param String
	 * @return N/A
	 */
	public void reporter(String message) {
		Reporter.log(message);
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
	public void type(String inputText, WebElement element) {
		element.clear();
		element.sendKeys(inputText);
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
	 * @Description Escribir texto en web element
	 * @author ncalzadillas
	 * @date 03/19/2022
	 * @param N/A
	 * @return N/A
	 */
	public void verifyElementIsPresent(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
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
			Reporter.log("<br> <img src='"+ fullPath +"'height='800' width='800'/></br>",true);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * @Description Verificar un text esperado
	 * @author ncalzadillas
	 * @date 03/26/2022
	 * @param String, String
	 * @return N/A
	 */
	public void validateExpectedText(String expected, String actual) {
		try {
			Assert.assertEquals(expected, actual);
			reporter("Expected text IS EQUAL to: [" + expected + "]", "Actual text IS EQUAL to: [" + actual + "]");
		}catch(AssertionError e) {
			//si no quiero que se detenga el script
			//reporter("Expected text [" + expected + "] IS NOT EQUAL to: [" + actual + "]");
			Assert.fail("Texts are not matching <b> expected: [ " + expected + "] and actual: [ " + actual + "] <b>");
		}
	}
	
	/**
	 * @Description Verificar un text esperado
	 * @author ncalzadillas
	 * @date 03/26/2022
	 * @param String, String
	 * @return N/A
	 */
	public void selectElementByValue(By locator, String expectedText) {
		List<WebElement> elements = findElements(locator);
		
		for(int i = 0; i<elements.size(); i++) {
			
			if(i>=elements.size()) {
				Assert.fail("El elemento que buscas en la lista no existe: [" 
						+ expectedText + "]");
			}
			
			if(elements.get(i).getText().equals(expectedText)) {
				reporter("Element in the list was clicked", elements.get(i).getText());
				elements.get(i).click();
				break;
			}
		}
		
	}
	
	/**
	 * @Description Seleccionar elemento por index
	 * @author ncalzadillas
	 * @date 03/26/2022
	 * @param By, int
	 * @return N/A
	 */
	public void selectDropDownByIndex(By locator, int index) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
		action.selectByIndex(index);
		reporter("Element was selected by Index", String.valueOf(index));
		}catch(StaleElementReferenceException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}catch(NoSuchElementException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}
	}
	
	/**
	 * @Description Seleccionar elemento por index
	 * @author ncalzadillas
	 * @date 03/26/2022
	 * @param By, int
	 * @return N/A
	 */
	public void selectDropDownByValue(By locator, String value) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
		action.selectByValue(value);
		reporter("Element was selected by value", value);
		}catch(StaleElementReferenceException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}catch(NoSuchElementException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}
	}
	
	/**
	 * @Description Seleccionar elemento por index
	 * @author ncalzadillas
	 * @date 03/26/2022
	 * @param By, int
	 * @return N/A
	 */
	public void selectDropDownByVisibleText(By locator, String expectedText) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
		action.selectByVisibleText(expectedText);
		reporter("Element was selected by Visible Text", expectedText);
		}catch(StaleElementReferenceException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}catch(NoSuchElementException e) {
			Assert.fail("Cannot select element: [ " + dropdown.toString() + " ]");
		}
	}
	
	/**
	* @throws N/A
	* @Description quite driver session
	* @Author Sergio Ramones
	* @Date 28/03/2022
	* @Parameter N/A
	* @return N/A
	* @implNote N/A
	*/
	public void closeBrowser() {
	driver.quit();
	}
	
	/**
	* @throws N/A
	* @Description This method is take today date plus the amount of days that you
	* are give by parameter and returned
	* @Author Sergio Ramones
	* @Date 04-JUN-2021
	* @Parameter int
	* @return String
	* @implNote N/A
	*/
	public String getDate(int amountDays) {

		Date myDate = new Date();
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");// ("YYYY-MM-dd"); MM/dd/YYYY

		Calendar cal = Calendar.getInstance();
		cal.setTime(myDate);
		cal.add(Calendar.DATE, amountDays);

		myDate = cal.getTime();

		String date = df.format(myDate);

		return date;

	 }
	
	/**
	* @throws JsonGenerationException, JsonMappingException, IOException
	* @Description Read JSON file
	* @Author Sergio Ramones
	* @Date 28/03/2022
	* @Parameter String, String
	* @return JsonNode
	* @implNote nodeTree.path("fieldName").asText()
	*/
	public JsonNode readJsonFileByNode(String jsonpath, String nodeName) {
		JsonNode nodeTree = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(new File(jsonpath));
			// Get Name
			nodeTree = root.path(nodeName);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nodeTree;
	}
	
	/**
	* @throws JsonGenerationException, JsonMappingException, IOException
	* @Description Read JSON file
	* @Author Sergio Ramones
	* @Date 28/03/2022
	* @Parameter String, String
	* @return JsonNode
	* @implNote nodeTree.path("fieldName").asText()
	*/
	public JsonNode readJsonFile(String jsonpath) {
		JsonNode root = null;
		try {
		ObjectMapper mapper = new ObjectMapper();
		root = mapper.readTree(new File(jsonpath));
		// Get Name
	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return root;
	}
}
