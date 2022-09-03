package elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class singleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/");
		
		Locator contactSales = page.locator("text = Contact Sales");
		
		//contactSales.click(); -- when there are multiple elements for an Locator, then Playwright Exception is thrown
		
		//com.microsoft.playwright.PlaywrightException: Error {
		//Error: strict mode violation: "text= Contact Sales" resolved to 2 elements:
			//    1) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka playwright.$("text=Contact Sales >> nth=0")
			//    2) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka playwright.$("text=Contact Sales >> nth=1")
		
		//contactSales.first().click();
		contactSales.last().click();
		//using first() or last() method we can access the respective Locator elements.
		
		String pageUrl = page.url();
		System.out.println(pageUrl);
		
		pw.close();
	}

}
