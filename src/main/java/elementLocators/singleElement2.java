package elementLocators;

import com.microsoft.playwright.*;

public class singleElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		Locator login = page.locator("text=Login");
		int loginsCount = login.count();
		System.out.println(loginsCount);
		login.first().click();
		
		pw.close();
	}

}
