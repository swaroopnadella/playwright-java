package authentication;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class useSavedStorageSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext =  browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
		
		Page page = brContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		Locator loc=page.locator("div");
		loc.allInnerTexts().forEach(e->System.out.println(e));
		
	}

}
