package selectors;

import com.microsoft.playwright.*;

public class textSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.opencart.com/");
		
		//text Selector - "tagname:has-text('value')"
		page.locator("p.hidden-xs a:has-text('Free Download')").click();
		System.out.println(page.url());
		
		page.goBack();
		page.locator("p.hidden-xs a:has-text('View Demo')").click();  //text Selector
		System.out.println(page.url());
		
		Locator loc = page.locator("'Official Documentation'");
		String offDocUrl = loc.getAttribute("href").toString();
		System.out.println("Using single quotes for text value: "+offDocUrl);
		
		Locator loc2 = page.locator("text=Official Documentation");
		String offDocUrl2 = loc2.getAttribute("href").toString();
		System.out.println("Using text equals to before value: "+offDocUrl2);
		
		//text=Official Documentation IS SAME AS 'Official Documentation'
		
		pw.close();
	}

}
