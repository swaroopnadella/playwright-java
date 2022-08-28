package launchBrowsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchFirefoxUI {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		//To see the browser UI, pass the headless=false flag while launching the browser.
		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://playwright.dev");
		System.out.println("Page Title: "+page.title());
		System.out.println("Page URL: "+page.url());
		
		browser.close();
		pw.close();
	}

}
