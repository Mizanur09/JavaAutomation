package Expariment;

import org.junit.Before;
import org.junit.Test;

import HelpingPages.GlobalizedPage;

public class Methods_TEST extends GlobalizedPage {

	
	@Before
	public void BeforeEachTest() {
		CP.Login_With_Consent_Agree();
		lb.Wait_For_Element(HP.HOMEPAGE_LOGOUT_BUTTON);
		
	}

	@Test
	public void Test() {
	
		
}
	
	
}