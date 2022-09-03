package elementLocators;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class multipleElementsUsingLambaForeach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
		List<String> optionsTextList = countryOptions.allTextContents();
		
		optionsTextList.forEach(ele -> System.out.println(ele));
		
		pw.close();
	}

}
