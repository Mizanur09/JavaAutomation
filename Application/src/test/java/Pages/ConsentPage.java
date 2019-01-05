package Pages;

import org.openqa.selenium.By;

import HelpingPages.GlobalizedPage;


public class ConsentPage extends GlobalizedPage{

//	####################### PAGE ELEMENTS	
	public By CONSENT_MODAL = By.cssSelector("#Div_LogInConfirmation_Modal");
	public By MODAL_HEADER_ELEMENT = By.cssSelector("#Div_LogInConfirmation_Modal .modal-header");
	public By DO_NOT_AGREE = By.cssSelector("[aria-label='I do not agree and wish to leave the site.']");
	public By I_CONSENT_AND_AGREE = By.cssSelector("[aria-label='I consent to monitoring and agree to comply with applicable regulations.']");
	public By CONTINUE_WITHOUT_LOGIN = By.cssSelector("#ModalNotLogInButton");
	public By CONSENT_PAGE_LOGIN_BUTTON = By.cssSelector("#ModalLogInButton");
	
//	####################### PAGE TEXTS
	public String MODAL_HEADER_TEXT = "DoD NOTICE ABOUT DoD COMMON ACCESS CARDS (CAC) AND CERTIFICATES& CONSENT TO MONITORING";
	
//	####################### Methods
	public ConsentPage Login_With_Consent_Agree() {
		lb.Wait_For_Element(CONSENT_MODAL);
		lb.Wait_For_Element(MODAL_HEADER_ELEMENT);
		lb.Element_ExptectedText(MODAL_HEADER_ELEMENT, MODAL_HEADER_TEXT);
		lb.Click_Element(I_CONSENT_AND_AGREE);
		lb.Click_Element(CONSENT_PAGE_LOGIN_BUTTON);
		return this;}
	
	public ConsentPage Login_WithOut_Agree() {
		lb.Wait_For_Element(MODAL_HEADER_ELEMENT);
		lb.Element_ExptectedText(MODAL_HEADER_ELEMENT, MODAL_HEADER_TEXT);
		lb.Click_Element(DO_NOT_AGREE);
		return this;}

	public ConsentPage Select_I_Consent_Agree() {
		lb.Click_Element(I_CONSENT_AND_AGREE);
		return this;
	}

}
