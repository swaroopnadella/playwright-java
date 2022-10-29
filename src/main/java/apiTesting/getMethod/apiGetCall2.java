package apiTesting.getMethod;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class apiGetCall2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		APIRequestContext apiRequestContext = pw.request()
				.newContext(new APIRequest.NewContextOptions().setBaseURL("https://reqres.in"));

		APIResponse response = apiRequestContext.get("/api/users/23");
		
		//Contains the URL of the response.
		System.out.println(response.url());

		//Contains a boolean stating whether the response was successful (status in the range 200-299) or not.
		System.out.println(response.ok()); //false

		// Contains the status code of the response (e.g., 200 for a success).
		System.out.println(response.status()); //404 - Not Found

		// Contains the status text of the response (e.g. usually an "OK" for a success).
		System.out.println(response.statusText());

		// Returns the text representation of response body.
		System.out.println(response.text());

		// An object with all the response HTTP headers associated with this response.
		System.out.println(response.headers());
		
		apiRequestContext.dispose();
		pw.close();
	}

}
