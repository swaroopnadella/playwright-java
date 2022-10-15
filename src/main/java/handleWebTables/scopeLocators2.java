package handleWebTables;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class scopeLocators2 {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://datatables.net/");

		Locator row = page.locator("table#example tr");

		Locator rowElements = row.locator(":scope", new Locator.LocatorOptions().setHasText("Bradley Greer")).locator(".dt-body-right");
		rowElements.allInnerTexts().forEach(e->System.out.println(e));
		
		System.out.println("*************************************");
		
		row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
		
		pw.close();
	}

}
