package recordVideos;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class recordVideoViewPortSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext(new Browser
															.NewContextOptions()
															.setRecordVideoDir(Paths.get("videos/"))
															.setRecordVideoSize(640, 480)); //desired video size.
		//video clarity will be reduced when we give lower resolution size
		
		Page page = brContext.newPage();
		page.navigate("https://www.facebook.com/");
		
		page.locator("[name='email']").fill("testuser007@mail.com");
		page.locator("#pass").fill("ASDFlkj1234");
		
		page.click("text=Create New Account");
		
		page.locator("[aria-label='First name']").fill("Test1");
		page.locator("[aria-label='Surname']").fill("Test2");
		page.locator("[aria-label='Mobile number or email address']").fill("testemailaddr@gmail.com"+"");
		page.locator("[aria-label='New password']").fill("QWERTY98765");
		page.locator("[aria-label='Re-enter email address']").fill("testemailaddr@gmail.com");
		page.click("'Male'");
		
		page.click("[name='websubmit']");
		
		page.close();
		brContext.close();
		browser.close();
	}

}
