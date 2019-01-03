package CustomUtility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import HelpingPages.GlobalizedPage;

public class LinkValidation extends GlobalizedPage{
	 
	 public void verifyActiveLinksStatus() throws Exception {
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.cssSelector("a"));
		System.out.println("Totle number of Links Present => " + links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement Element = links.get(i);
			String PageLinks = Element.getAttribute("href");
			System.out.println("@ Link Name => " + Element.getText());

			if (PageLinks !=null) {
				try {
					URL LinkUrl = new URL(PageLinks);
					HttpURLConnection httpURLConnection = (HttpURLConnection)LinkUrl.openConnection();
					httpURLConnection.setConnectTimeout(7000);
					httpURLConnection.setRequestMethod("GET");
					httpURLConnection.connect();
					
					if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_CLIENT_TIMEOUT){
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_BAD_METHOD){
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_CONFLICT){
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR){
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_ENTITY_TOO_LARGE) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_ACCEPTABLE) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_PRECON_FAILED) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_REQ_TOO_LONG) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_UNAVAILABLE) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_UNSUPPORTED_TYPE) {
						System.out.println("Status code (" + httpURLConnection.getResponseCode() + ") Status Message { " + httpURLConnection.getResponseMessage() + " } Link URL [ " + PageLinks + " ]");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					}					
			}else {
				System.out.println("************************** Above Links has no href attachment to it ");
			}
		}
	}
	
	
	
	
	
	
	
	
}
