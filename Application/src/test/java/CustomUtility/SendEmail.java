package CustomUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SendEmail {
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 						DO NOT TOUCH THIS LIBRARY
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

	XSSFWorkbook WorkBrrok;
	XSSFSheet Sheet;
	
	String Hostname = "smtp.gmail.com";
	String SetFrom = "Mizanur.rahman@halfaker.com";
	String SetSubject = "TestMail";
	int portNumber = 465;
	
	
	String FilePath = "test-output/emailable-report.html";
	String SetMassege = "This is the test report which is automated created and sent. there no control over this. if you with to be remove please send a email back to this email"
			+ "there for I can take you out from there.";

	public static ArrayList<String> attachInfo() {
		ArrayList<String> EmailBody = new ArrayList<String>();
		EmailBody.add("Mizanur.rahman0918@gmail.com");
		EmailBody.add("Mizanur.rahman@halfaker.com");
		EmailBody.add("mr64885@gmail.com");
		return EmailBody;
	}
	
	public void sendEmailAfterTest() {
		try {
			Email email = new SimpleEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("mr64885@gmail.com", "01553351844Raj"));
				email.setSSLOnConnect(true);
				email.setFrom("mr64885@gmail.com");
				email.setSubject("TestMail");
				email.setMsg("This is a test mail ... :-)");
				email.addTo("Mizanur.rahman@halfaker.com");
				email.send();
			System.out.println("Email has been sent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}

	public void SendEmailWithAttachmentMultipleUser() {
		try {
			EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(FilePath);
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("TEST REPORT");
			MultiPartEmail email = new MultiPartEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("mr64885@gmail.com", "01553351844Raj"));
				email.setSSLOnConnect(true);
				email.setFrom(attachInfo().get(2), "Mizanur Rahman");
				email.addTo(attachInfo().get(0), "Mizanur");
				email.addTo(attachInfo().get(1), "Rahman");
				email.setSubject("Test email with inline image");
				email.setMsg(SetMassege);
				email.attach(attachment);
				email.send();
			System.out.println("Email has been sent");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	
//##########################################################
	public void SenEmailByExcelData() {
		
		try {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(GetValue_By_SheetName("Email_Information",8,1));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription(GetValue_By_SheetName("Email_Information",7,1));

		MultiPartEmail email = new MultiPartEmail();
			email.setHostName(GetValue_By_SheetName("Email_Information",4,1));
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(GetValue_By_SheetName("Email_Information",1,1),
					GetValue_By_SheetName("Email_Information",2,1)));
			email.setSSLOnConnect(true);
			email.setFrom(GetValue_By_SheetName("Email_Information",1,1),GetValue_By_SheetName("Email_Information",3,1));
			email.addTo(GetValue_By_SheetName("Email_Information",1,2), GetValue_By_SheetName("Email_Information",3,2));
			email.addTo(GetValue_By_SheetName("Email_Information",1,3), GetValue_By_SheetName("Email_Information",3,3));
			email.setSubject(GetValue_By_SheetName("Email_Information",5,1));
			email.setMsg(GetValue_By_SheetName("Email_Information",6,1));
			email.attach(attachment);
			email.send();
			System.out.println("Email has been sent");
		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String GetValue_By_SheetName(String SheetName, int RowNumber, int ColumnNumber) {
		String ExcelData = null;
		try {
			File FilePath = new File("ResourceFolder/ExcelDoc/TestData.xlsx");
			FileInputStream File = new FileInputStream(FilePath);
			WorkBrrok = new XSSFWorkbook(File);
			Sheet = WorkBrrok.getSheet(SheetName);
			ExcelData = Sheet.getRow(RowNumber).getCell(ColumnNumber).getStringCellValue();
			System.out.println("Data From SheetName => "+ SheetName+") RowNumber => " + RowNumber
					+ "} Value of the Column => " + ColumnNumber + "] Value is ===> " + ExcelData);
			WorkBrrok.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return ExcelData;
	}
//	########################################################################################
	

}
