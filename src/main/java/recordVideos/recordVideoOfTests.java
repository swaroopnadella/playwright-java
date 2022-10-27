package recordVideos;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class recordVideoOfTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext(new Browser
															.NewContextOptions()
															.setRecordVideoDir(Paths.get("videos/")));
		
		Page page = brContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
		page.click("text=MacBook");
		
		page.click("'Add to Cart'");
		
		page.click("'Shopping Cart'");
		
		page.locator("#content").allInnerTexts().forEach(e->System.out.println(e));
		
		page.close();
		brContext.close();
		browser.close();
	}

}
