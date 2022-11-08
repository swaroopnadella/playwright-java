package getByLocatorAPIs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class beforeGetByAPIs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright pw=Playwright.create();
		Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		
		Locator firstBookCoverImg = page.locator("[alt='Book cover image']");
		for(int i=0;i<firstBookCoverImg.count();i++) {
			String txt = firstBookCoverImg.nth(i).getAttribute("src");
			System.out.println(txt);
		}
		
		Locator txtbox = page.locator("[placeholder='Search books or authors']");
		txtbox.fill("Locator Placeholder used");
		Thread.sleep(2000);
		
		txtbox = page.locator("[role='combobox']");
		txtbox.fill("Locator Role used");
		Thread.sleep(2000);
		
		String githubClassAttribute = page.locator("text=Login").getAttribute("class");
		System.out.println(githubClassAttribute);
		
		//page.locator("text=Submit"); 						--Tried
		//page.locator("role=button"); 						--Tried
		//page.locator("text=Password");
		//page.locator("[placeholder='Search Github']");	--Tried
		//page.locator("[alt='castle']"); 					--Tried
		//page.locator("[title='Place the order']");
		//page.locator("data-testid='submit']");
		
		pw.close();
	}

}
