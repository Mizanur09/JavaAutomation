package CustomUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import HelpingPages.GlobalizedPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtility extends GlobalizedPage{

   /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 						DO NOT TOUCH THIS LIBRARY
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/


	public WebDriver Start_FireFox_Browser(String URL) {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
		} catch (Exception e) {
			lb.Print("Error:" + e.getMessage());
			e.getStackTrace();
		}
		return driver;
	}

	public WebDriver Start_Chrome_Browser(String URL) {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			lb.Select_Certificate_Chrome_Browser(URL);
		} catch (Exception e) {
			lb.Print("Error:" + e.getMessage());
			e.getStackTrace();
		}
		return driver;
	}

	public WebDriver Start_Internet_Explorar_Browser(String URL) {
		try {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
		} catch (Exception e) {
			lb.Print("Error:" + e.getMessage());
			e.getStackTrace();
		}
		return driver;
	}

	public WebDriver Start_Microsoft_Edge_Browser(String URL) {
		try {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
		} catch (Exception e) {
			lb.Print("Error:" + e.getMessage());
			e.getStackTrace();
		}
		return driver;
	}

	public void Browser_Capability() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}

	public WebDriver Start_Browser_By_Name(String BrowserName, String URL) {
		try {
			if (BrowserName.contains("IE")) {
				driver = Start_Internet_Explorar_Browser(URL);
			} else if (BrowserName.contains("FireFox")) {
				driver = Start_FireFox_Browser(URL);
			} else if (BrowserName.contains("Chrome")) {
				driver = Start_Chrome_Browser(URL);
			} else if (BrowserName.contains("Adge")) {
				driver = Start_Microsoft_Edge_Browser(URL);
			}
			Browser_Capability();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
		return driver;
	}

	public String GetBrowserName() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String Platform = cap.getPlatform().toString();
		String Version = cap.getVersion().toString();
		String BrowserName = cap.getBrowserName().toUpperCase();
		return "Platform => (" + Platform + ")  BROWSER Name => '" + BrowserName + "' Version => (" + Version + ")";
	}

	public WebDriver Close_Browser() {
		driver.close();
		return driver;
	}

	
	
}
