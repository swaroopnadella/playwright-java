package handleFrames;

import com.microsoft.playwright.*;

public class frameUsingXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");
		
		page.locator("img[title='Club Signup Forms and Templates']").click();
		
		page.frameLocator("//iframe[contains(@id,'frame-one')]")
							.locator("#RESULT_TextField-2").fill("PlaywrightAutomation");
		
		pw.close();
		
	}

}
