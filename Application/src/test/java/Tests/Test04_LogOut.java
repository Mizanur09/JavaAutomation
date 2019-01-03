package Tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import HelpingPages.GlobalizedPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test04_LogOut extends GlobalizedPage {

	@BeforeClass
	public static void BeforeThisTest() {
		lb.Print("========>>> Logout Test Started ");
	}
	By DropDownList = By.cssSelector(".navbar-right ul");
	
	@Test
	public void Test01_login_To_BOSS() {
		lb.Wait_For_Element(CP.CONSENT_MODAL);
		lb.Wait_For_Element(CP.MODAL_HEADER_ELEMENT);
		lb.Element_ExptectedText(CP.MODAL_HEADER_ELEMENT, CP.MODAL_HEADER_TEXT);
		lb.Click_Element(CP.I_CONSENT_AND_AGREE);
		lb.Click_Element(CP.CONSENT_PAGE_LOGIN_BUTTON);
		lb.Wait_For_Element(HP.HOMEPAGE_HEADER);
		lb.Verify_Element_State(lb.GetElement(HP.HOMEPAGE_HEADER).isDisplayed(), true);
	}

	@Test
	public void Test02() {
		lb.Click_Element(HP.SUBMIT_REQUEST_FIELD);
		lb.Click_From_List_By_Element_Text(DropDownList, "On Demand Support");
	}
	
	@Ignore
	@Test
	public void Test03_LogOut_from_BOSS_System() {
		lb.Wait_For_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
		lb.Click_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
		lb.Wait_For_Element(LP.LOGOUT_PAGE_LOGIN_BUTTON);
		lb.Verify_Element_State(lb.Is_Element_Present(LP.LOGOUT_PAGE_LOGIN_BUTTON), true);
		lb.Verify_Element_State(lb.GetElement(HP.ANONYMOUS_USER).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.HOME_LINK).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.SUBMIT_REQUEST_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.LOGOUT_MESSAGE_FIELD).isDisplayed(), true);
		lb.Element_ExptectedText(HP.LOGOUT_MESSAGE_FIELD, "You have been logged out.");
	}
}
