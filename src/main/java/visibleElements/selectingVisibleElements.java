package visibleElements;

import java.util.List;

import com.microsoft.playwright.*;

public class selectingVisibleElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");

		List<String> linksText = page.locator("a:visible").allInnerTexts();
		System.out.println(linksText.size());
		linksText.forEach(ele -> System.out.println(ele));
		System.out.println("*********************************************************");

		String inputBox = page.locator("input:visible").nth(0).getAttribute("aria-label");
		System.out.println(inputBox);
		String inputBox1 = page.locator("input:visible").nth(1).getAttribute("type");
		System.out.println(inputBox1);
		System.out.println("*********************************************************");
		
		page.locator("input:visible").nth(0).fill("macbook");
		page.keyboard().press("Enter");
		
		Thread.sleep(5000);
		List<String> macbookResults = page.locator("a:visible").allInnerTexts();
		System.out.println(macbookResults.size());
		macbookResults.forEach(ele -> System.out.println(ele));
		
		System.out.println("*********************************************************");
		int imgCount = page.locator("//img >> visible=true").count();
		System.out.println(imgCount);
		pw.close();

	}

}
