package CustomUtility;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import HelpingPages.GlobalizedPage;

public class ScreenShot extends GlobalizedPage{

	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 						DO NOT TOUCH THIS LIBRARY
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

	public String Create_ScreenShot_Name(Description des) {
		String Final_ScreenShot_Class_Name = null;
		String Final_ScreenShot_Method_Name = null;
		try {
			Final_ScreenShot_Class_Name = des.getClassName();
			Final_ScreenShot_Method_Name = des.getMethodName();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.getStackTrace();
		}
		return "Class_Name (" + Final_ScreenShot_Class_Name + ") Test_Name (" + Final_ScreenShot_Method_Name;
	}
	
	// ########## ScreenShot
	public String Take_ScreenShot(String screenShotName, String saveLocationPath) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,
					// FileUtils.copyFile(screenshot, new File(saveLocationPath + "Element"+ "_" + lb.Get_Current_Time() + ".Png"));
					new File(saveLocationPath + screenShotName + ".Png"));
		} catch (Exception e) {
			lb.Print("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return "Path: " + saveLocationPath + " ClassName: " + screenShotName + ".Png" ;
	}

	public void Take_Screen_Shot_Of_Element(By by) {
		try { // THIS METHODS IS NOT WORKING
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage FullImage = ImageIO.read(screenshot);
			Point point = lb.GetElement(by).getLocation();
			int elementWidth = lb.GetElement(by).getSize().getWidth();
			int elementHeight = lb.GetElement(by).getSize().getHeight();
			System.out.println(elementHeight);
			System.out.println(elementWidth);

			BufferedImage ElementScreenshot = FullImage.getSubimage(point.getX(), point.getY(), elementWidth,
					elementWidth);
			ImageIO.write(ElementScreenshot, ".Png", screenshot);
			FileUtils.copyFile(screenshot, new File("test.PNG"));
			// FileUtils.copyFile(screenshot, new File(saveLocationPath + "Element"+ "_" + lb.Get_Current_Time() + ".Png"));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
	}
}
