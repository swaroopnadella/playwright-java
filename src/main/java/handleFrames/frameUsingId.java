package handleFrames;

import com.microsoft.playwright.*;

public class frameUsingId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/frames");
		
		String str = page.frameLocator("#frame2").locator("h1").textContent();
		System.out.println(str);
		
		pw.close();
		
	}

}
