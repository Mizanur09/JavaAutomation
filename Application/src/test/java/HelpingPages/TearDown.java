package HelpingPages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import CustomUtility.Library;
import CustomUtility.ScreenShot;

public class TearDown {

	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		// DO NOT TOUCH THIS LIBRARY

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public static WebDriver driver;
	
//	PAGES
	public static Library lb = new Library();
	public static ScreenShot Sshot = new ScreenShot();
	
//	URLS
	static String BOSS_QA = "https://10.82.11.102/";
	static String BOSS_UAT = "https://supportrequest.uat.militaryonesource.mil/";
	
//	PATHS
	protected String ScreenshotPath = "ResourceFolder/FailuerScreenShot/";
	protected String ExcelFilePath = "C:/Users/mizanur.rahman/Desktop/EXPERIMENT/EXCEL_FOLDER/EXCELTEST.xlsx";
	
	
	@BeforeClass
	public static void BeforeTest() throws Exception {
		lb.Start_Browser_By_Name("Chrome", BOSS_UAT);
		lb.setDemoMode(false);
		lb.Print(lb.GetBrowserName());
	}

	@Rule
	public TestRule listen = new TestWatcher() {
		@Override
		public void failed(Throwable t, Description description) {
			String Screenshot = Sshot.Take_ScreenShot(Sshot.Create_ScreenShot_Name(description), ScreenshotPath);
			lb.Print(Screenshot);
			
//			if (driver != null) {
//				driver.close();
//				driver.quit();
//			}
		} 
		
		@Override 
		public void succeeded(Description description) {
//			lb.Print("Every working fine");
		}
	};

	@AfterClass
	public static void AfterTest() {
		lb.Print("All Test Are Completed (*_*)");
		lb.Close_Browser();
	}

}
