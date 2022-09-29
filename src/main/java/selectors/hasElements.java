package selectors;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class hasElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://dzone.com/");
		
		//Locator for footer which has About link
		Locator footer = page.locator("ul.link-group:has(a[href='/pages/about'])");
		footer.allInnerTexts().forEach(e->System.out.println(e));
		
		System.out.println("***************************");
		//Locator for footer which has Writers Zone link
		Locator footer2 = page.locator("ul.link-group:has(a[href='/writers-zone'])");
		footer2.allInnerTexts().forEach(e->System.out.println(e));
		
		pw.close();
	}

}
