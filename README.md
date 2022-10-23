# Playwright Basics - Java
[This repository has my Practice code for various topics listed below]
Refer Official Docs for detailed examples and code samples -> https://playwright.dev/java/docs/intro

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
 
 i. Text selector locates elements that contain passed text.
 - text=value IS SAME AS 'value' when we specify inside method page.locator("");
 - example: page.locator("text=value"); page.locator("'value'");
 - tagname:has-text('value')
 - example: page.locator("a:has-text('View Demo')");
 - Input elements of the type button and submit are matched by their value instead of text content. 
      example, text=Log in matches < input type=button value="Log in" >.
 			
 ii. CSS Selectors
 - Selector strategy is same as like Selenium usage.
 - tagname and classvalue is written as -> tagname.classvalue
 - tagname and idvalue is written as -> tagname#idvalue
 - we can use parent tag (div.demonstration-box) followed by space then child tag name(img) to form an CSS Selector
 - Example: "div.demonstration-box img"
   
 iii. React Selectors
 - React selectors allow selecting elements by its component name and property values.
 - React selectors can be more stable than the DOM element selectors, as the property values are specific to the React components and not the HTML DOM structure.
 - React Developer Tools browser extension helps to identify the react selectors on the React web application. We can test them using the Playwright CLI by launching the codegen for the website.
 - Use the Components and Profiler in the DevTools (F12) of the web browser to identify the React selectors.
 - Syntax for React selectors: "_react=componentName[attributeName='attributeValue']"
 - Example code for React selectors with Netflix website: page.locator("_react=UISelect[data-uia='language-picker']")

5. Frames
 - frameLocator method : using selector
 - frame method : using name

6. Shadow DOM Elements (shadow-root)
 - shadow-root elements can be accessed the same way like other elements (non shadow-root)
 - No need to use the Javascriptexecutor code in Playwright, which is needed in Selenium.

7. Web Tables
 - Using the Scope selector we can work on the Web Table elements.
 - Syntax - locator(":scope") method
 - We can pass a unique value to select an row and perform operations on the elements in that row.

8. Authentication - Reuse signed in state
 - By Reusing the signed in session state, we can skip the log in step for all of the tests.
 - Step1 is save the logged in session state as json file using the Browser context
 - Step2 is use the state json in the tests Browser context and we can auto login.

9. Handling Javascript Dialogs using Handler
 - Javascript Dialogs are three types
   - JS Alert : has OK button
   - JS Confirm : has Cancel and OK buttons
   - JS Prompt : has Textbox, Cancel and OK buttons
 - When an JS Dialog appears on the Web page, Playwright automatically handles it (Clicking on Cancel or OK). No additional code required.
 - By Using the onDialog Handler on the JS Dialog we can do the following actions.
	  - Retrieve the message 
	  - Click Ok (accept)
	  - Click Ok with prompt text (accept with specified text)
	  - Click Cancel (dismiss)
