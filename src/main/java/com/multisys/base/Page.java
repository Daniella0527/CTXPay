package com.multisys.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.multisys.utilities.ExcelReader;
import com.multisys.utilities.ExtentManager;
import com.multisys.utilities.Utilities;


public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static OutputStream fos;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator
			+ "multisys" + File.separator + "excel" + File.separator + "testdata.xlsx");

	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator
			+ "excel" + File.separator + "testdata.xlsx";

	public static TopMenu menu;
	
	static String getUserAppDirectory() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("mac") >= 0) {
			return System.getProperty("user.home") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator ;

		}
		if (os.indexOf("win") >= 0) {
			return System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator;

		} else
			return System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator;
	}

	public Page() {

		System.setProperty("userApp.root", getUserAppDirectory());

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator + "properties" + File.separator + "Config.properties");
	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator + "properties" + File.separator + "OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
			
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
			} else if (config.getProperty("browser").equals("ie")) {

				WebDriverManager.iedriver().setup();

				InternetExplorerOptions capabilities = new InternetExplorerOptions();
				capabilities.ignoreZoomSettings();
				driver = new InternetExplorerDriver(capabilities);

			}
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			menu = new TopMenu(driver);
		}
	}

	public static void quit() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();

	}

	// Common Keywords
	
	public static String getText(String locator) {
		WebElement element;
		 String text = new String();

		if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
		}

		log.debug("Copying text on an Element : " + locator);
		test.log(LogStatus.INFO, "Copying text on : " + locator);
		return text;

	}
	
	
	public static void click(String locator) {
		WebElement element;

		if (locator.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else if (locator.endsWith("_ID")) {
			element = driver.findElement(By.id(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}

		log.debug("Clicking on an Element : " + locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static void type(String locator, String value) {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		if (locator.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);

		} else if (locator.endsWith("_ID")) {
			element = driver.findElement(By.id(OR.getProperty(locator)));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		}

		log.debug("Typing in an Element : " + locator + " entered value as : " + value);

		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}

	static WebElement dropdown;

	public void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : " + locator + " value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}
public boolean isElementPresent(String locator) {

		try {
			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator)));
			}
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src="
					+ Utilities.screenshotName + " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

	}

	public static void newTab(String url) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1000);
		String finalurl = config.getProperty(url);
		
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);
		String newTab = handlesList.get(handlesList.size() - 1);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.titleIs("New Tab"));
		// wait.until(ExpectedConditions.titleContains("New Tab"));

		driver.switchTo().window(newTab);
		driver.get(finalurl);
	}


public static void verifyPayment(String paymentMethod) throws IOException, InterruptedException{
	WebElement element = driver.findElement(By.xpath(OR.getProperty("PaymentMethod_XPATH")));
	String pm = element.getText();
	verifyEquals(paymentMethod, pm);
}


}

