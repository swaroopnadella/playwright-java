package selectors;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class hasElements2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");
		
		//Locator for country dropdown which has value of Australia
		Locator country = page.locator("select#Form_getForm_Country:has(option[value='Australia'])");
		
		country.allInnerTexts().forEach(e->System.out.println(e));
		country.allTextContents().forEach(e->System.out.println(e));
		
		pw.close();
	}

}
