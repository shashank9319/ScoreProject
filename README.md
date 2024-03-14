Automation Suite for theScore Mobile App


This repository contains an automation suite developed for testing the mobile application "theScore" using a hybrid (data-driven) framework. The suite is built upon TestNG, Appium, Selenium, and Java, designed to ensure comprehensive coverage and reliability of the application's features.

Overview
 
The automation suite is tailored for theScore, a popular sports application that provides scores, news, statistics, and betting information. The suite aims to automate the testing of various functionalities within the mobile app, ensuring a seamless and error-free user experience.

Features

Cross-platform Testing: Designed to run tests on both Android and IOS platforms, ensuring broad coverage.

Data-Driven Approach: Utilizes external data sources for test data, enabling easy scalability and maintainability of test cases.

Page Object Model (POM): Implements POM for better readability, maintainability, and reusability of the code.

Comprehensive Test Coverage: Covers test scenarios, as per requirements.

Detailed Reporting: Generates detailed test reports using TestNG and Extent Reports, providing insights into test execution.

Retry Listener Feature:

The Retry Listeners feature enhances the robustness of the test suite by attempting to execute each test case up to three times if it does not pass on the initial try. This mechanism is designed to ensure that transient issues or flakiness in tests do not lead to immediate failure. If a test case fails to pass after three attempts, it will then be marked as failed. This feature significantly improves the reliability of the testing process by providing multiple opportunities for a test to succeed, thereby minimizing the impact of temporary glitches or environmental issues on the overall test results.




Prerequisites

Before setting up the project, ensure you have the following installed:

Java JDK 10 or higher
Appium2
Android SDK / iOS SDK (depending on your testing platform)
Maven (for managing dependencies)

NOTE:
For IOS as I don't have MacBook, couldn't define elements, however, developed the framework in suchaway that if we define elements for IOS, we can run the suite and test.
Apk used for testing is attached in Apk folder in the suite.


Prerequisites for Running the Automation Suite

To ensure the successful execution of the automation suite, please follow the steps outlined below:

Appium 2.0 Installation: The suite requires Appium version 2.0. Please install this version prior to execution. Detailed installation instructions can be found on the official Appium website.

Android SDK and Emulator Configuration: It is necessary to have the Android SDK configured and an Android 11 emulator created for tests that run on an emulator. Should you opt to use a different version of Android, please update the androidPlatformVersion field in the AppData file accordingly to match your chosen version.

Starting the Appium Server: Prior to executing the suite via the command line, initiate the Appium server by executing the appium command. Although the suite is designed to work without manual initiation of the Appium server, manual startup is recommended for smoother operation. In cases where the Appium server is not started manually, ensure that the paths are correctly updated for withAppiumJS to locate the Appium main.js file and usingDriverExecutable for the Node.js executable in AppiumServer.java file.

Please adhere to these prerequisites to guarantee a smooth and efficient testing process. Should you encounter any issues, please feel free to reach out to me at eshashank93@gmail.com.