package Tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import HelpingPages.GlobalizedPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test02_Continue_WithOut_login_HomePage extends GlobalizedPage {

	@Test
	public void Test01_GoTo_Home_Page_Without_Loggin() throws Exception {
		Assert.assertEquals("BOSS - Request Forms", driver.getTitle());
		HP.Go_To_Home_Page();
	}

	@Test
	public void Test02_Verify_BOSS_Logo_Navigation() {
		HP.Pagelogo_Navigation();
	}

	@Test
	public void Test03_Verify_Home_Link_Takes_to_HomePAge() {
		HP.Home_Link_Navigation();
	}

	@Test
	public void Test04_Verify_User_Notice() {
		lb.Element_ExptectedText(HP.USER_NOTICE, HP.USER_NOTICE_TEXT);
	}

	@Test
	public void Test05_Verify_All_Field_Present_HomePage() {
		lb.Verify_Element_State(lb.Is_Element_Present(HP.PAGE_LOGO), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.ANONYMOUS_USER), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.HOME_LINK), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SUBMIT_REQUEST_FIELD), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.DASHBOARD_FIELD), false);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.REPORT_FIELD), false);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.MANAGE_FIELD), false);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.HOMEPAGE_LOGIN_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.CONTACTUS_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.OND_RESOURCE_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.CAMPS_RESOURCE_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SURGE_RESOURCE_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.ROT_RESOURCE_BUTTON), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.FIND_OUT_BUTTON), true);
	}

	@Test
	public void Test06_Verify_Submit_Request_Forms_dropdown() {
		lb.Click_Element(HP.SUBMIT_REQUEST_FIELD);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SubmitRequest_OND), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SubmitRequest_CAMP), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SubmitRequest_SURG), true);
		lb.Verify_Element_State(lb.Is_Element_Present(HP.SubmitRequest_ROT), true);
	}

	@Test
	public void Test07_Verify_ContactUs_Modal() {
		lb.Click_Element(HP.CONTACTUS_BUTTON);
		HP.ContactUs_PopUp_Modal();
	}

	@Test
	public void Test08_FindOut_What_Is_AbailAble_Information() {
		lb.Scroll_Into_View(HP.FINDOUT_MILITARY_PROVIDER_INFORMATION_BOX);
		lb.Verify_Element_State(lb.GetElement(HP.FINDOUT_MILITARY_PROVIDER_INFORMATION_BOX).isDisplayed(), true);
		lb.Element_ExptectedText(HP.FINDOUT_MILITARY_PROVIDER_INFORMATION_BOX, HP.MILITARY_PROVIDER_INFORMATION);
	}

	@Test
	public void Test09_Verify_FindOut_What_AvailAble_PopUp() {
		lb.Scroll_Into_View(HP.FIND_OUT_BUTTON);
		lb.Click_Element(HP.FIND_OUT_BUTTON);
		HP.What_Available_PopUp_modal();
	}

	@Test
	public void Test10_Military_OneSource_link() {
		String GetMainWindow = lb.Get_Parent_Window();
		lb.Click_Element(HP.FINDOUT_MILITARY_ONESOURCE_PROVIDER_TOOLS_LINK);
		lb.Switch_To_Tab("Military OneSource Products");
		lb.Expected_Page_Header("PRODUCTS");
		lb.Close_Browser();
		lb.Switch_Back_To_Main_Window(GetMainWindow);
		lb.Element_ExptectedText(HP.HOMEPAGE_HEADER, HP.HOMEPAGE_HEADER_TEXT);
	}
}
