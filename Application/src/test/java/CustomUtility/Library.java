package CustomUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import HelpingPages.GlobalizedPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Library extends GlobalizedPage {

	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 						DO NOT TOUCH THIS LIBRARY
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

	// Bowser Certificates
	public void Select_Certificate_Chrome_Browser(String URL) throws IOException {
		URL url = new URL(URL);
		Thread certSelectionThread = null;

		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Delay_Given_Time(2);
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyPress(KeyEvent.VK_ENTER);
				} catch (AWTException e) {
					Print(e.getMessage());
					e.printStackTrace();
				} catch (Exception e) {
					Print(e.getMessage());
					e.printStackTrace();
				}
			}
		};
		certSelectionThread = new Thread(r);
		certSelectionThread.start();
		driver.navigate().to(url);
	}
	// #####################################################################################################################
	
	/*
	 * @param Example GetElement("input[id^='First part of the ID']")); Example
	 * GetElement("input[id$='last part of the ID']")); Example
	 * GetElement("input[id*='last part of the ID']")); Example
	 * GetElement(#ID);Select the ID Example GetElement(.class); Select the class
	 * Example GetElement("ul[li='Attribute']+[p='Attribute']") adding all the Attribute one after other Example GetElement("ul>li"); immediate child
	 * Example GetElement("ul li"); one of the element under the parent 
	 * Example GetElement("html>div:nth-child(child number)"); It is the second child of a parent 
	 * Example GetElement("p:nth-of-typ(child number)"); Select the second child of a parent
	 * Example GetElement( Any xpath);
	 * Example GetElement(id,className,linkText,tagName,Name and partialLinkText) any one should do the job
	 */
	public WebElement GetElement(By by) {
		return driver.findElement(by);
	}
	
	public void Click_Element(By by) {
		High_Light_Element(GetElement(by));
		Fluent_Wait(by).click();
	}

	public void Element_ExptectedText(By by, String textvalue) {
		try {
			String actual = GetElement(by).getText().trim().replace("\n", "");
			Print("Expected Text is => " + "[" + textvalue + "]" + " Got this => " + "[" + actual + "]");
			Print("************************************************************");
			Assert.assertEquals(textvalue, actual);
		} catch (Exception e) {
			Print("ERROR: " + e.getMessage());
			e.getStackTrace();
		}
	}

	public void ClickElementByName(String elementName) {
		try {
			List<WebElement> Entirepage = driver.findElements(By.cssSelector("html body div"));
			for (int i = 0; i < Entirepage.size(); i++) {
				WebElement allElement = Entirepage.get(i);
				String value = allElement.getText();
				if (value.equalsIgnoreCase(elementName)) {
					allElement.click();
					break;
				}
			}
		} catch (Exception e) {
			Print(e.getMessage());
			e.getStackTrace();
		}
	}
	
	public void ClickELemenByAttribute(String Attribute, String AttributeValue) {
		try {
			List<WebElement> page = driver.findElements(By.cssSelector("html body div"));

			for (int i = 0; i < page.size(); i++) {
				WebElement allElement = page.get(i);
				String value = allElement.getAttribute(Attribute);
				if (value.equalsIgnoreCase(AttributeValue)) {
					allElement.click();
					break;
				}
			}
		} catch (Exception e) {
			Print(e.getMessage());
			e.getStackTrace();
		}
	}
//#############################################

	/*
	 * Should only be able to Print anything with string... 
	 */
	public void Print(String text) {
		System.out.println(text);
	}
	
	public String Get_Current_URL() {
		return driver.getCurrentUrl();
	}

	public void Verify_Element_State(boolean actual, boolean expected) {
		Assert.assertEquals(expected, actual);
	}

	public void Verify_String_Match(String TitleName, String Actual) {
		Assert.assertEquals(TitleName, Actual);
	}

	public void Expected_Page_Header(String TitleName) {
		try {
			String actual = GetElement(By.cssSelector("h1")).getText().trim().replace("\n", " ");
			Print("Expected page Header is => " + "[" + TitleName + "]" + " got this => " + "[" + actual + "]");
			Print("************************************************************");
			Assert.assertEquals(TitleName, actual);
		} catch (Exception e) {
			Print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ########################## Is ....?
	public boolean Is_Element_Present(By by) {
		boolean present;
		try {
			GetElement(by);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}

	// ############################################## JavaScripts
	public void High_Light_Element(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			Wait_For_Half_Second();
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
		}catch (Exception e) {
			Print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Scroll_Into_View(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", GetElement(by));
		}catch (Exception e) {
			Print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void Click_Element_By_javaScript(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GetElement(by));
		} catch (Exception e) {
			Print("ERROR: " + e.getMessage());
			e.getStackTrace();
		}
	}

	// ######################################################### WAITS
	// #########################
	public void Delay_Given_Time(int number) {
		try {
			Thread.sleep(1000 * number);
		} catch (Exception e) {
			Print(e.getMessage());
			e.printStackTrace();
		}
	}

	public void Wait_For_Half_Second() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Print(e.getMessage());
			e.printStackTrace();
		}
	}

	public WebElement Fluent_Wait(final By by) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return GetElement(by);
				}
			});
		} catch (Exception e) {
			Print(e.getMessage());
			e.printStackTrace();
		}
		return targetElem;
	}
	
	public String Get_Parent_Window() {
		String ParentWindowHandle = driver.getWindowHandle();
		return ParentWindowHandle;
	}
	
	// ##### Special wait
	public void Wait_For_Element(By by) {
		WebDriverWait pageWait = new WebDriverWait(driver, 15);
		pageWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// ##################################### Window Switch
	// #####################################
	public void Switch_To_Tab(String Title) {
		try {
			String currentTab = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				if (driver.switchTo().window(winHandle).getTitle().equals(Title)) {
					Print("The title of the current Tab is => " + driver.getTitle());
					break;
				} else {
					driver.switchTo().window(currentTab);
				}
			}
		} catch (Exception e) {
			Print("ERROR: " + e.getMessage());
			e.getStackTrace();
		}
	}

	public String Get_Active_Element_Name() {
		WebElement Active = driver.switchTo().activeElement();
		return Active.getText().trim();
	}

	public void Switch_Back_To_Main_Window(String text) {
		driver.switchTo().window(text);
	}

	// ######################### Select
	public void Select_From_List_By_Value(By by, String targetValue) {
		try {
			WebElement dropDownElem = driver.findElement(by);
			Select selectList = new Select(dropDownElem);
			selectList.selectByVisibleText(targetValue);

		} catch (Exception e) {
			Print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Select_From_List_By_Index_Number(By by, int targetvalue) {
		try {
			WebElement dropdwn = driver.findElement(by);
			Select selectlist = new Select(dropdwn);
			selectlist.selectByIndex(targetvalue);
		} catch (Exception e) {
			Print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Print_Selected_Value(By by) {
		List<WebElement> SelectedFromList = driver.findElements(by);

		for (int i = 0; i < SelectedFromList.size(); i++) {
			if (SelectedFromList.get(i).getAttribute("selected") == null) {
				Print("Selected Board Name => " + "[" + SelectedFromList.get(i).getAttribute("value") + "]");
			} else {
				Print("Selected Board Name => " + SelectedFromList.get(i).getAttribute("value"));
			}
		}
	}

	public void Click_If_Text_Match(WebElement element, String Field) {
		if (element.getText().equals(Field)) {
			Print(element.getText());
			High_Light_Element(element);
			element.click();
		} else {
			Print("Could Not find the Field By this name " + Field);
		}
	}

	// Time Stamp
	public String Get_Current_Time() {
		String timeStamp = null;
		try {
			timeStamp = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(Calendar.getInstance().getTime());
		} catch (Exception e) {
			Print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return timeStamp;
	}

	// ###### UPLOAD FILE
	public void Upload_File(By by, String absulatepathforfile) {
		try {
			WebElement uploadfile = GetElement(by);
			uploadfile.sendKeys(absulatepathforfile);
		} catch (Exception e) {
			Print("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
//	public void Download(By by) {
//		File folder = new File();
//		
//		GetElement(by).click();
//		Thread.sleep(2000);
//		File ListOfFiles[] = folder).ListOfFiles();
//		Assert.assertTrue(condition);
//	}
	
	public void ApplicationErrorLogs() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry : logEntries) {
			System.out.println(entry.getLevel()+" "+entry.getMessage());
		}
	}

	// #### Mouse Over
	public void Move_Mouse_To_Elemnt(By by) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(GetElement(by)).build().perform();
			High_Light_Element(GetElement(by));
			Delay_Given_Time(1);
		} catch (Exception e) {
			Print("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	/* Table search with (Table element, Row Number, Column Number Will Return Text
	 * from the table
	 */
	// ########### Table search
	public String Table_Search(By Table, int Row_Number, int Column_Number) {
		String Result = null;
		WebElement table = GetElement(Table);
		List<WebElement> Rows = table.findElements(By.tagName("tr"));
		int I_Row = 1;
		for (WebElement Rows_Temp : Rows) {
			if (I_Row == Row_Number) {
				List<WebElement> Columns = Rows_Temp.findElements(By.tagName("td"));
				int I_Columns = 1;
				for (WebElement Columns_Temp : Columns) {
					if (I_Columns == Column_Number) {
						return Result = Columns_Temp.getText();
					}
					System.out.println("Row: " + I_Row + ", col: " + I_Columns + ", Data: " + Columns_Temp.getText());
					I_Columns++;
				}
			}
			I_Row++;
		}
		return Result;
	}

	public void Click_From_List_By_Element_Text(By DropDownList, String TargatedText) {
		try {
			WebElement parant = GetElement(DropDownList);
			List<WebElement> Child = parant.findElements(By.tagName("li"));
			for (WebElement TempList : Child) {
				if (TempList.getText().equals(TargatedText)) {
					Print("Found The Targated Text (" + TargatedText + ")");
					Print("The Given Text Is => (" + TargatedText + ")  And The Targated Text Is => ("
							+ TempList.getText() + ")");
					High_Light_Element(TempList);
					TempList.click();
					break;
				} else {
					Print("Could not Find The Given Text In The List (" + TargatedText + ")");
				}
			}
		} catch (Exception e) {
			Print("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private Boolean isDemoMode = false;

	public void setDemoMode(Boolean isDemoMode) {
		this.isDemoMode = isDemoMode;
	}

	public void HightLight(WebElement element) {
		if (isDemoMode == true) {
			try {
				for (int i = 0; i < 10; i++) {
					WrapsDriver WrappedElement = (WrapsDriver) element;
					JavascriptExecutor driver = (JavascriptExecutor) WrappedElement.getWrappedDriver();
					Thread.sleep(500);
					driver.executeScript("arguments[0].setAttribute('style',arguments[1]", element,
							"color: red; border: 2px solid yellow;");
					driver.executeScript("arguments[0].setAttribute('style',arguments[1]", element, "");
				}
			} catch (Exception e) {
				Print("Error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
}
