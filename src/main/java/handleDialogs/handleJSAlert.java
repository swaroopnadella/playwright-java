package handleDialogs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class handleJSAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Java script Alert (Alert Popup has OK Button)
		//Clicking OK on the JS Alert is automatically Handled by Playwright when Alert popup appears. 
		//No additional code is required.
		page.click("text=Click for JS Alert");
		String result=page.textContent("#result");
		System.out.println(result);
		//text printed on Console: You successfully clicked an alert
		
		
	}

}
