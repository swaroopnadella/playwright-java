package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class browserContextsUsage {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		// BrowserContext opens the session in Incognito mode. 
		// It won't share cookies/cache with other browser contexts.
		
		BrowserType chromium = pw.chromium();
		// Create a Chromium browser instance
		Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// Create two isolated browser contexts
		BrowserContext userContext = browser.newContext();
		BrowserContext adminContext = browser.newContext();
		
		// Create pages and interact with contexts independently
		Page userPage = userContext.newPage();
		userPage.navigate("https://yahoomail.com/");
		System.out.println(userPage.title());
		
		Page adminPage = adminContext.newPage();
		adminPage.navigate("https://gmail.com/");
		System.out.println(adminPage.title());
		
		pw.close();
	}

}
