package handleDialogs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class handleJSPrompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Javascript Prompt (Prompt Popup has Textbox, Cancel button and OK Button)
		//Clicking Cancel on the JS Prompt is automatically Handled by Playwright when Prompt popup appears. 
		//No additional code is required.
		page.click("text=Click for JS Prompt");
		String result=page.textContent("#result");
		System.out.println(result);
		//text printed on Console: You entered: null
		
		page.close();
		pw.close();
	}

}
