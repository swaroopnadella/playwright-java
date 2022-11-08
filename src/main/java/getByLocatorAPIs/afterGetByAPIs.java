package getByLocatorAPIs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class afterGetByAPIs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright pw=Playwright.create();
		Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		
		Locator firstBookCoverImg = page.getByAltText("Book cover image");
		for(int i=0;i<firstBookCoverImg.count();i++) {
			String txt = firstBookCoverImg.nth(i).getAttribute("src");
			System.out.println(txt);
		}
		
		Locator txtbox = page.getByPlaceholder("Search books or authors");
		txtbox.fill("GetByPlaceholder used");
		Thread.sleep(2000);
		
		txtbox = page.locator("[role='combobox']");
		txtbox.fill("GetByRole used");
		Thread.sleep(2000);
		
		String githubClassAttribute = page.getByText("Login").getAttribute("class");
		System.out.println(githubClassAttribute);
		
		//page.getByText('Submit');					--Tried
		//page.getByRole('button');					--Tried
		//page.getByLabel('Password')
		//page.getByPlaceholder('Search Github')	--Tried
		//page.getByAltText('castle')				--Tried
		//page.getByTitle('Place the order')
		//page.getByTestId('submit')
		
		pw.close();
	}

}
