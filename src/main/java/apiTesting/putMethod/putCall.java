package apiTesting.putMethod;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class putCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");

		Playwright pw = Playwright.create();
		APIRequestContext apiRequestContext = pw.request().newContext(
				new APIRequest.NewContextOptions().setBaseURL("https://reqres.in/").setExtraHTTPHeaders(headers));

		Map<String, String> payload = new HashMap<>();
		payload.put("name", "morpheus test");
		payload.put("job", "zion resident test");
		
		APIResponse response = apiRequestContext.put("/api/users/2", RequestOptions.create().setData(payload));
		
		// Contains the URL of the response.
		System.out.println(response.url());

		// Contains a boolean stating whether the response was successful (status in the
		// range 200-299) or not.
		System.out.println(response.ok()); // true

		// Contains the status code of the response.
		System.out.println(response.status()); // 200

		// Contains the status text of the response.
		System.out.println(response.statusText()); //OK

		// Returns the text representation of response body.
		System.out.println(response.text());

		// An object with all the response HTTP headers associated with this response.
		System.out.println(response.headers());
	}

}
