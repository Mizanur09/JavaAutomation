package HelpingPages;
import CustomUtility.ExcelHandaler;
import CustomUtility.LinkValidation;
import CustomUtility.SendEmail;
import Pages.ConsentPage;
import Pages.HomePage;
import Pages.Login_LogOut_Page;
import Pages.Request_Forms;

/*                                   DO NOT TOUCH THIS PAGE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

public class GlobalizedPage extends TearDown{
	
	public static HomePage HP = new HomePage();
	public static ConsentPage CP = new ConsentPage();
	public static Request_Forms RF = new Request_Forms();
	public static Login_LogOut_Page LP = new Login_LogOut_Page();
	
	
//	Moduals


	public static ExcelHandaler exel = new ExcelHandaler();
	public static LinkValidation linkv = new LinkValidation();
	public static SendEmail Semail = new SendEmail();























}
