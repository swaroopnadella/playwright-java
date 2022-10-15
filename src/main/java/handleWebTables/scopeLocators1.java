package handleWebTables;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class scopeLocators1 {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.primefaces.org/primeng/");

		Locator row = page.locator("p-table.p-element tr");

		row.locator(":scope", new Locator.LocatorOptions()
				.setHasText("Lenna Paprocki"))
				.locator("div.p-checkbox-box.p-component")
				.click();
		
		System.out.println("*************************************");
		
		row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));

	}

}
