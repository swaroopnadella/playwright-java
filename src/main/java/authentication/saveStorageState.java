package authentication;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class saveStorageState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
		
		Page page = brContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		page.locator("#input-email").fill("testuseroct2022@gmail.com");
		page.locator("#input-password").fill("nCxhyCKA4fDWDqj");
		page.locator("role=button[name='Login']").click();
		
		brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
		
	}

}
