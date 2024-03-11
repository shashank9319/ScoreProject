Automation Suite for theScore Mobile App


This repository contains an automation suite developed for testing the mobile application "theScore" using a hybrid (data-driven) framework. The suite is built upon TestNG, Appium, Selenium, and Java, designed to ensure comprehensive coverage and reliability of the application's features.

Overview
 
The automation suite is tailored for theScore, a popular sports application that provides scores, news, statistics, and betting information. The suite aims to automate the testing of various functionalities within the mobile app, ensuring a seamless and error-free user experience.

Features

Cross-platform Testing: Designed to run tests on both Android and iOS platforms, ensuring broad coverage.

Data-Driven Approach: Utilizes external data sources for test data, enabling easy scalability and maintainability of test cases.

Page Object Model (POM): Implements POM for better readability, maintainability, and reusability of the code.

Comprehensive Test Coverage: Covers test scenarios, as per requirements.

Detailed Reporting: Generates detailed test reports using TestNG and Extent Reports, providing insights into test execution.

Prerequisites

Before setting up the project, ensure you have the following installed:

Java JDK 10 or higher
Appium2
Android SDK / iOS SDK (depending on your testing platform)
Maven (for managing dependencies)

NOTE:
For IOS as I don't have MacBook, couldn't define elements, however, developed the framework in suchaway that if we define elements for IOS, we can run the suite and test.
Apk used for testing is attached in Apk folder in the suite.