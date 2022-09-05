# Playwright Basics - Java

1. Cross Browser Testing (launchBrowsers) - Chromium, Firefox, WebKit browser binaries are available
 - Default browser mode is headless
 - Set headless to false to launch Browser UI
 - Chromium can be used with channel as Chrome or MS Edge browsers
 - WebKit is the rendering engine for Safari browser
 - Testing the upcoming versions by setting the channel like "chrome-beta", "msedge-beta" etc

2. Browser Context
 - Launches the browser sessions in the Incognito mode
 - Each Browser Context won't share cookies/cache with other browser contexts.
 - Browser contexts can also be used to emulate multi-page scenarios involving mobile devices, permissions, locale and color scheme.
 - Browser contexts are isolated environments on a single browser instance
 - This is useful when you want to test for multi-user functionality, like chat
 
 3. Locators
 - Locators represent a way to find DOM element(s) on the page.
 - Locators are strict, so if more than one element matches with given selector and we try to perform operations then Exception is thrown
 - Using first(), last() methods we can disable strictness and perform actions of corresponding elements.
 - To access multiple elements with same selector, we can use the count() and nth index methods
 
 4. Selectors
 - i. Text selector locates elements that contain passed text.
 		-- text=value IS SAME AS 'value' when we specify inside method page.locator("");
 		-- example: page.locator("text=value"); page.locator("'value'");
 		-- tagname:has-text('value')
 		-- example: page.locator("a:has-text('View Demo')");
 			
 - ii. CSS Selectors
 		-- Selector strategy is same as like Selenium usage.
 		-- tagname and classvalue is written as -> tagname.classvalue
 		-- tagname and idvalue is written as -> tagname#idvalue
 		-- we can use parent tag (div.demonstration-box) followed by space then child tag name(img) to form an CSS Selector
 		-- Example: "div.demonstration-box img"

 5. Frames
 	- Using frameLocator and frame methods
 	- Different selectors - id, name, xpath, css selector