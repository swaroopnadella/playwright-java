package handleFrames;

import com.microsoft.playwright.*;

public class frameUsingName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://www.londonfreelance.org/courses/frames/index.html");
		
		Frame frame = page.frame("main");
		String st = frame.locator("h2").textContent();
		System.out.println(st);
		
		pw.close();
		
	}

}
