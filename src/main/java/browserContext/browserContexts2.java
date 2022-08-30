package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class browserContexts2 {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//BrowserContext opens the session in Incognito mode. It won't share cookies/cache with other browser contexts. 
		BrowserContext bcx1 = browser.newContext();
		Page page1 = bcx1.newPage();
		page1.navigate("http://yahoo.com");
		System.out.println(page1.title());
		page1.close();
		bcx1.close();
		
		BrowserContext bcx2 = browser.newContext();
		Page page2 = bcx2.newPage();
		page2.navigate("http://netflix.com");
		System.out.println(page2.title());
		page2.close();
		bcx2.close();
		
		BrowserContext bcx3 = browser.newContext();
		Page page3 = bcx3.newPage();
		page3.navigate("http://hotmail.com");
		System.out.println(page3.title());
		page3.close();
		bcx3.close();
		
		
	}

}
