package Pages;

import org.openqa.selenium.By;

import HelpingPages.GlobalizedPage;

public class HomePage extends GlobalizedPage{

	public By HOMEPAGE_HEADER = By.cssSelector("h2:nth-child(1)");
	public By PAGE_LOGO = By.cssSelector("#logo-link");
	public By ANONYMOUS_USER = By.cssSelector(".navbar-right>li>p");
	public By USER_NOTICE = By.cssSelector(".body-content  td:nth-child(2)");
	public By HOME_LINK = By.partialLinkText("Home");
	public By HOMEPAGE_LOGIN_BUTTON = By.cssSelector("#LogInButton");
	public By HOMEPAGE_LOGOUT_BUTTON = By.cssSelector("[title='Log Out']");
	
	public By OND_RESOURCE_BUTTON = By.cssSelector("[onclick=\"location.href='/Request/OnDemand'\"]");
	public By CAMPS_RESOURCE_BUTTON = By.cssSelector("[onclick=\"location.href='/Request/Camps'\"]");
	public By SURGE_RESOURCE_BUTTON = By.cssSelector("[onclick=\"location.href='/Request/Surge'\"]");
	public By ROT_RESOURCE_BUTTON = By.cssSelector("[onclick=\"location.href='/Request/Rotational'\"]");
	
	public By SUBMIT_REQUEST_FIELD = By.partialLinkText("Submit Request");
	public By SubmitRequest_OND = By.partialLinkText("On Demand Support");
	public By SubmitRequest_CAMP = By.partialLinkText("Camps Support");
	public By SubmitRequest_SURG = By.partialLinkText("Surge Support");
	public By SubmitRequest_ROT = By.partialLinkText("Rotational Support");
	
	public By CURRENT_LOGGED_IN_USER_PROFILE = By.cssSelector("#userprofile-link");
	public By DASHBOARD_FIELD = By.linkText("Dashboard");
	public By REPORT_FIELD = By.linkText("Reports");
	public By MANAGE_FIELD = By.linkText("Manage");
	public By ATTENTION_FIELD = By.cssSelector(".alert.alert-danger.alert-dismissible.show");
	
	public By CONTACTUS_BUTTON = By.cssSelector(".well.col-md-10 button");
	public By CONTACTUS_POPUP_BODY = By.cssSelector("#ContactUsModal .modal-content");
	public By CONTACTUS_POPUP_X_BUTTON = By.cssSelector("#ContactUsModal [aria-label='Close']");
	public By CONTACTUS_POPUP_HEADER = By.cssSelector("#ContactUsModal h3");
	public By CONTACTUS_POPUP_BODY_ELEMENT = By.cssSelector("#ContactUsModal .modal-body");
	public By CONTACTUS_POPUP_CLOSE_BUTTON = By.cssSelector("#ContactUsModalCloseButton");
	
	public By FIND_OUT_BUTTON = By.cssSelector("[aria-label='Not sure what support materials are offered? Find out what is available.']");
	public By FINDOUT_POPUP_MODAL_BOADY = By.cssSelector("#myModal .modal-content");
	public By FINDOUT_POPUP_X_BUTTON = By.cssSelector("#myModal .close");
	public By FINDOUT_POPUP_BODY_ELEMENT = By.cssSelector("#myModal .modal-body ul");
	public By FINDOUT_POPUP_CLOSE_BUTTON = By.cssSelector("#ModalCloseButton");
	public By FINDOUT_MILITARY_PROVIDER_INFORMATION_BOX = By.cssSelector(".well-footer .well-sm");
	public By FINDOUT_MILITARY_ONESOURCE_PROVIDER_TOOLS_LINK = By.linkText("Military OneSource Provider Tools");
	
	public By LOGOUT_MESSAGE_FIELD = By.cssSelector(".body-content");

//	####################### PAGE TEXTS
	
	public String USER_NOTICE_TEXT = "NOTICE TO USERS: YOU DO NOT NEED TO LOGIN TO SUBMIT A REQUEST";
	public String HOMEPAGE_HEADER_TEXT = "Resources Available to Service Providers and Leaders from the Department of Defense";	
	public String FINDOUT_POPUP_BODY_TEXT = "Military OneSource offers downloadable and orderable materials such as brochures, magnets, pens, "
												+ "DVDs, educational items and resource guides – all at no cost to eligible members."
												+ "See a complete list of materials available on the Products page at MilitaryOneSource.mil."
												+ "Contact Military OneSource at 800-342-9647 for assistance with the online ordering process.";
	
	public String CONTACTUS_POPUP_BODY_TEXT = "Contact Us"
												+ "We welcome your questions concerning Military OneSource, "
												+ "Military and Family Life Counseling, and Child and Youth "
												+ "Behavioral Counseling services by e-mail or "
													+ "phone:"
														+ "Email: osd.pentagon.ousd-p-r.mbx.mcfp-nmc@mail.mil"
														+ "Phone: 571-372-4530."
												+ "Please contact us with your Personal Financial Counseling questions by e-mail or"
													+ " phone:"
														+ "Email: osd.mc-alex.ousd-p-r.mbx.financial-readiness@mail.mil"
														+ "Phone: 703-695-3090.";	
	
	public String MILITARY_PROVIDER_INFORMATION = "If you need support materials only, "
												+ "please visit Military OneSource Provider Tools."
												+ "Not sure what support materials are offered?"
														+ "Find out what is available.";	
	
//#########################################################################################################################################
	
	public HomePage Go_To_Home_Page() {
		CP.Select_I_Consent_Agree();
		lb.Click_Element(CP.CONTINUE_WITHOUT_LOGIN);
		lb.Element_ExptectedText(HOMEPAGE_HEADER, HOMEPAGE_HEADER_TEXT);
		return this;
	}
	
	public HomePage Pagelogo_Navigation() {
		lb.Click_Element(PAGE_LOGO);
		lb.Element_ExptectedText(HOMEPAGE_HEADER, HOMEPAGE_HEADER_TEXT);
		return this;
	}
	
	public HomePage Home_Link_Navigation() {
		lb.Click_Element(HOME_LINK);
		lb.Element_ExptectedText(HOMEPAGE_HEADER, HOMEPAGE_HEADER_TEXT);
		return this;
	}
	
	public HomePage What_Available_PopUp_modal() {
		lb.Wait_For_Element(FINDOUT_POPUP_MODAL_BOADY);
		lb.Verify_Element_State(lb.GetElement(FINDOUT_POPUP_MODAL_BOADY).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(FINDOUT_POPUP_X_BUTTON).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(FINDOUT_POPUP_X_BUTTON).isEnabled(), true);
		lb.Element_ExptectedText(FINDOUT_POPUP_BODY_ELEMENT, FINDOUT_POPUP_BODY_TEXT);
		lb.Verify_Element_State(lb.GetElement(FINDOUT_POPUP_CLOSE_BUTTON).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(FINDOUT_POPUP_CLOSE_BUTTON).isEnabled(), true);
		lb.Click_Element(FINDOUT_POPUP_CLOSE_BUTTON);
		return this;
	}
	
	public HomePage ContactUs_PopUp_Modal() {
		lb.Wait_For_Element(CONTACTUS_POPUP_BODY);
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_BODY).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_HEADER).isDisplayed(), true);
		lb.Element_ExptectedText(CONTACTUS_POPUP_HEADER, "Contact Us");
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_X_BUTTON).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_X_BUTTON).isEnabled(), true);
		lb.Element_ExptectedText(CONTACTUS_POPUP_BODY_ELEMENT, CONTACTUS_POPUP_BODY_TEXT);
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_CLOSE_BUTTON).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(CONTACTUS_POPUP_CLOSE_BUTTON).isEnabled(), true);
		lb.Click_Element(CONTACTUS_POPUP_CLOSE_BUTTON);
		return this;
	}
	
	public String Get_User_Name() {
		lb.Wait_For_Element(CURRENT_LOGGED_IN_USER_PROFILE);
		String getFirstName = lb.GetElement(CURRENT_LOGGED_IN_USER_PROFILE).getText().split(" ")[2];
		String getlastName = lb.GetElement(CURRENT_LOGGED_IN_USER_PROFILE).getText().split(" ")[3];
		String FullName = getFirstName+" "+getlastName;
		return FullName;
	  }
	
	public HomePage Verify_All_Management_Field_Are_Present() {
		lb.Verify_Element_State(lb.GetElement(PAGE_LOGO).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(CURRENT_LOGGED_IN_USER_PROFILE).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HOME_LINK).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(SUBMIT_REQUEST_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(DASHBOARD_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(REPORT_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(MANAGE_FIELD).isDisplayed(), true);
		lb.Verify_Element_State(lb.GetElement(HOMEPAGE_LOGOUT_BUTTON).isDisplayed(), true);
		return this;
	}
	
	
	
}
