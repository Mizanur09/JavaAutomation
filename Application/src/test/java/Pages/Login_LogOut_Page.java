package Pages;

import org.openqa.selenium.By;

import HelpingPages.GlobalizedPage;

public class Login_LogOut_Page extends GlobalizedPage{

//	####################### PAGE ELEMENTS		
	public By CONTINUE_WITHOUT_LOGIN = By.cssSelector("#ModalNotLogInButton");
	public By LOGOUT_PAGE_LOGIN_BUTTON = By.cssSelector("[type='button']");
	
//	####################### PAGE TEXTS
	
//	####################### Methods
	public Login_LogOut_Page LogIn_To_BOSS() {
		lb.Wait_For_Element(CP.CONSENT_MODAL);
		lb.Wait_For_Element(CP.MODAL_HEADER_ELEMENT);
		lb.Element_ExptectedText(CP.MODAL_HEADER_ELEMENT, CP.MODAL_HEADER_TEXT);
		lb.Click_Element(CP.I_CONSENT_AND_AGREE);
		lb.Click_Element(CP.CONSENT_PAGE_LOGIN_BUTTON);
		lb.Wait_For_Element(HP.HOMEPAGE_HEADER);
		lb.Verify_Element_State(lb.GetElement(HP.HOMEPAGE_HEADER).isDisplayed(), true);
		return this;
	}
	
	public Login_LogOut_Page Logout_From_BOSS() {
		lb.Wait_For_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
		lb.Click_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
		lb.Wait_For_Element(LOGOUT_PAGE_LOGIN_BUTTON);
		lb.Verify_Element_State(lb.Is_Element_Present(LOGOUT_PAGE_LOGIN_BUTTON), true);
		lb.Verify_Element_State(lb.GetElement(HP.ANONYMOUS_USER).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.HOME_LINK).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.SUBMIT_REQUEST_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HP.LOGOUT_MESSAGE_FIELD).isDisplayed(), true);
		lb.Element_ExptectedText(HP.LOGOUT_MESSAGE_FIELD, "You have been logged out.");
		return this;
	}
	
}
