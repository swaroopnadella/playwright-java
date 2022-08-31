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
