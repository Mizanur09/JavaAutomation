package Expariment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExperimaneMethod {

	
	static WebDriver driver;
	public static By CONSENT_MODAL = By.cssSelector("#Div_LogInConfirmation_Modal");
	public static By MODAL_HEADER_ELEMENT = By.cssSelector("#Div_LogInConfirmation_Modal .modal-header");
	public static By I_CONSENT_AND_AGREE = By.cssSelector("[aria-label='I consent to monitoring and agree to comply with applicable regulations.']");
	public static By CONSENT_PAGE_LOGIN_BUTTON = By.cssSelector("#ModalLogInButton");
	public static By HOMEPAGE_HEADER = By.cssSelector("h2:nth-child(1)");
	
	
	public static void main(String[] args) throws Exception {

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
		Select_Certificate_Chrome_Browser("https://supportrequest.uat.militaryonesource.mil/");
		WebDriverWait pageWait = new WebDriverWait(driver, 15);
		
		pageWait.until(ExpectedConditions.visibilityOfElementLocated(CONSENT_MODAL));
		System.out.println(driver.findElement(MODAL_HEADER_ELEMENT).getText());
		driver.findElement(I_CONSENT_AND_AGREE).click();
		driver.findElement(CONSENT_PAGE_LOGIN_BUTTON).click();
		pageWait.until(ExpectedConditions.visibilityOfElementLocated(HOMEPAGE_HEADER));
		Thread.sleep(2000);
		System.out.println(driver.findElement(HOMEPAGE_HEADER).getText());
		
		
		driver.quit();
	}
	         

	public static void Select_Certificate_Chrome_Browser(String URL) throws IOException {
		
		URL url = new URL(URL);
		Thread certSelectionThread = null;
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyPress(KeyEvent.VK_ENTER);
				} catch (AWTException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		};
		certSelectionThread = new Thread(r);
		certSelectionThread.start();
		driver.navigate().to(url);
	}
	
}
