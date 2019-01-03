package Tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import HelpingPages.GlobalizedPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test03_Continue_With_Logging_In_HomePage extends GlobalizedPage {

	@BeforeClass
	public static void BeforeThisTest() throws Exception {
		CP.Login_With_Consent_Agree();
		lb.Print("%%%%%%%%%%%  Starting HomePage After login testing  %%%%%%%%%%%");
		lb.Wait_For_Element(HP.ANONYMOUS_USER);
	}

	@Test
	public void Test01_Verify_All_Fields_Are_Present_For_logged_In_User() {
		lb.Verify_Element_State(lb.GetElement(HP.PAGE_LOGO).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.CURRENT_LOGGED_IN_USER_PROFILE).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.HOME_LINK).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.SUBMIT_REQUEST_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.DASHBOARD_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.REPORT_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.MANAGE_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.HOMEPAGE_LOGOUT_BUTTON).isDisplayed(), true);
//		lb.Take_ScreenShot("Test03_Continue_With_Logging_In_HomePage", "FailuerScreenShot");
	}

	@Test
	public void Test02_Verify_User_Name_Displays_In_User_Profile() {
		lb.GetElement(HP.CURRENT_LOGGED_IN_USER_PROFILE).getText().contains(HP.Get_User_Name());
		lb.Print("Current Logged In User Is ===>" + HP.Get_User_Name());
	}

	@Test
	public void Test03_Verify_BOSS_Logo_And_Home_Link_Takes_User_To_Home_Page() {
		lb.Click_Element(HP.PAGE_LOGO);
		lb.Wait_For_Element(HP.HOME_LINK);
		String Logo_Navigation_URL = lb.Get_Current_URL();
		lb.Click_Element(HP.HOME_LINK);
		lb.Wait_For_Element(HP.HOME_LINK);
		String Home_Link_Navigation_URL = lb.Get_Current_URL();
		lb.Verify_String_Match(Logo_Navigation_URL, Home_Link_Navigation_URL);
	}

}
