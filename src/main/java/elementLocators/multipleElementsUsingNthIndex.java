package elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class multipleElementsUsingNthIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
		for(int i=0;i<countryOptions.count();i++) {
			//Returns locator to the n-th matching element. It's zero based, nth(0) selects the first element.
			String text = countryOptions.nth(i).textContent();
			System.out.println(text);
		}
		
		pw.close();
	}

}
