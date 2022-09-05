package handleFrames;

import com.microsoft.playwright.*;

public class frameLocatorMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://www.londonfreelance.org/courses/frames/index.html");
		
		String str = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(str);
		
		pw.close();
		
	}

}
