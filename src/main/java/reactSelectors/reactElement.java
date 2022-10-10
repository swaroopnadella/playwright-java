package reactSelectors;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class reactElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.netflix.com/in/");
		
		Locator email = page.locator("_react=[name='email'] >> input").first();
		email.click();
		email.fill("reactselectors@testing.com");
		
		Locator getStarted = page.locator("_react=[text='Get Started']").first();
		getStarted.click();
		
		Thread.sleep(5000);
		
		Locator text = page.locator("_react=UIMarkup");
		text.allInnerTexts().forEach(e->System.out.println(e));
		
		page.goBack();
		
		page.locator("_react=UISelect[data-uia='language-picker']").click();
		System.out.println("************************");
		Locator footer = page.locator("_react=[data-uia='data-uia-footer-label']");
		footer.allInnerTexts().forEach(e->System.out.println(e));
		
	}

}
