#  Swag-Labs-Automation-testing-Project
## Description
This project is designed to test Swag Labs Website using Automation. [Swag-Labs-Website](https://www.saucedemo.com/)
## Scope
The scope of this automation testing will cover the following areas:
- Functional Testing: Verifying that all features and functionalities of the website work as intended. This includes testing login functionality, adding to cart functionality, checkout prices added correctly, checkout functionality, payement functionality and any other interactive elements.
- Usability Testing: Ensuring that the website is easy to use and navigate.
## Test Strategy
- Automated Testing: Automated tests will be developed for the identified functionalities. This includes unit tests for individual components, integration tests for combined functionalities, and end-to-end tests for complete user flows.
## Tools
- Selenium WebDriver: For automating web applications for testing purposes. It supports multiple programming languages like Java,etc.
- TestNG Framework: For unit testing and integration testing. These frameworks provide annotations to identify test methods and assertions to verify outcomes.
- Maven/Gradle: For building and managing the project, including dependencies and running tests.
- Allure report : provides a comprehensive analysis of test execution, including test steps, start time, duration, and status.
## Environment Setup
- Testing Tools: Selenium WebDriver for automating web applications, TestNG for unit and integration testing.
- Build Tools: Maven for managing dependencies and building the project.
- Operating System: Ensure the testing environment uses the same operating system as the production environment." Linux : Ubuntu"
- Browser Versions: If testing web applications, use the same browser versions as your users."Google chrome Version 129.0.6668.70 (Official Build) (64-bit)"
- TestNG Framework: Configure the testing framework to use the correct test runner and set up any necessary annotations or configurations.
- POM Design pattern: design pattern in Selenium that creates an object repository for storing all web elements. It helps reduce code duplication and improves test case maintenance.
- Allure report : provides a comprehensive analysis of test execution, including test steps, start time, duration, and status.
- Version Control Git: to manage the test scripts and configurations.
## Test Design 
Designed 6 pages of the website and but any element and expected actions in it which are : 
- P01_LoginPage
- P02_LandingPage
- P03_CartPage
- P04_CheckoutPage
- P05_OverviewPage
- P06_FinishPage

Designed 6 Test pages to include test cases for each page in it according to POM design pattern with anonymous object and fluent design pattern approach which are:
- TC01_LoginTest
- TC02_LandingTest
- TC03_CartTest
- TC04_CheckoutTest
- TC05_OverviewTC
- TC06_FinalTest

Used Listeners to tracke events that occur during the execution of a test script like:
- IInvokedMethodListenerClass
- ITestLestenerClass

Used Logs (Log4j2) to extract information about how the execution took place.  
Used Json and properities files to create a data driven framework and not use a static data.  
Used Allure report to provide a comprehensive analysis of test execution, including test steps, start time, duration, and status.

