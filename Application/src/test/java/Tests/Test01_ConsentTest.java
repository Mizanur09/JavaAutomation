package Tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import HelpingPages.GlobalizedPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test01_ConsentTest extends GlobalizedPage {

	@Test
	public void Test01_Verify_Button_Are_Disable_When_Nothing_Is_Selected() {
		lb.Wait_For_Element(CP.CONSENT_MODAL);
		lb.Verify_Element_State(lb.GetElement(CP.CONSENT_PAGE_LOGIN_BUTTON).isEnabled(), true);
		lb.Verify_Element_State(lb.GetElement(CP.CONTINUE_WITHOUT_LOGIN).isEnabled(), false);
	}

//	@Test
//	public void Test02_Verify_Button_Are_Disable_When_User_Select_I_Do_Not_Agree_Button() {
//		lb.Click_Element(CP.DO_NOT_AGREE);
//		lb.Verify_Element_State(lb.GetElement(CP.CONSENT_PAGE_LOGIN_BUTTON).isEnabled(), false);
//		lb.Verify_Element_State(lb.GetElement(CP.CONTINUE_WITHOUT_LOGIN).isEnabled(), false);
//	}
//
//	@Test
//	public void Test03_Verify_Button_Are_Enabled_When_I_Consent_And_Agree_Radio_Button_Is_Selected() {
//		lb.Wait_For_Element(CP.CONSENT_MODAL);
//		lb.Element_ExptectedText(CP.MODAL_HEADER_ELEMENT, CP.MODAL_HEADER_TEXT);
//		lb.Click_Element(CP.I_CONSENT_AND_AGREE);
//		lb.Wait_For_Element(CP.CONTINUE_WITHOUT_LOGIN);
//		lb.Verify_Element_State(lb.GetElement(CP.CONTINUE_WITHOUT_LOGIN).isEnabled(), true);
//		lb.Verify_Element_State(lb.GetElement(CP.CONSENT_PAGE_LOGIN_BUTTON).isEnabled(), true);
//	}
//
//	@Test
//	public void Test04_Verify_Button_Are_Disable_When__USet_Select_back_I_Do_Not_Agree_Button() {
//		lb.Click_Element(CP.DO_NOT_AGREE);
//		lb.Wait_For_Element(CP.CONTINUE_WITHOUT_LOGIN);
//		lb.Verify_Element_State(lb.GetElement(CP.CONSENT_PAGE_LOGIN_BUTTON).isEnabled(), false);
//		lb.Verify_Element_State(lb.GetElement(CP.CONTINUE_WITHOUT_LOGIN).isEnabled(), false);
//	}
//
//	@Test
//	public void Test05_Verify_User_Is_Login_Is_Successful() {
//		CP.Login_With_Consent_Agree();
//		lb.Element_ExptectedText(HP.HOMEPAGE_HEADER, HP.HOMEPAGE_HEADER_TEXT);
//		lb.Wait_For_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
//		HP.Verify_All_Management_Field_Are_Present();
//	}

}
