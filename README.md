# Selenium WebDriver Test Automation - Module 7 Task

This project implements a test automation framework for the **Module 7 Task** using the web application [https://automationexercise.com](https://automationexercise.com). It is built with **Selenium WebDriver**, **Java**, and **TestNG**, following the **Page Object Model (POM)** design pattern and automation best practices.

The framework automates 3 linear test scenarios based on public test cases from the application (Test Case 1, 2, and 16).

Logging is implemented using Log4j to provide detailed test execution insights, improving debugging, monitoring, and traceability.

---

## 📌 Scenarios Implemented

### ✅ Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

---

### ✅ Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible 

---

### ✅ Test Case 16: Place Order Login before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

---

## 🧪 Technologies Used

- Java 21 (Springboot)
- Selenium WebDriver  
- TestNG  
- Maven
- Log4j2  

---

## 🏗️ Project Architecture

### Directory Structure
```
automation-exercise-tests/
├── evidence/                          # Execution screenshots (PASS)
│   ├── loginUser_PASS_*.png
│   ├── registerUser_PASS_*.png
│   └── placeOrder_PASS_*.png
├── logs/
│   └── test-execution.log             # Execution logs
├── screenshots/                       # Error screenshots (NOT PASS)
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java              # Base test configuration
│       │   ├── driver/
│       │   │   └── DriverSingleton.java       # WebDriver Singleton
│       │   ├── pages/
│       │   │   ├── BasePage.java              # Abstract page (inheritance)
│       │   │   ├── AuthPage.java              # Login / Signup page
│       │   │   ├── HomePage.java              # Home page
│       │   │   ├── ProductsPage.java          # Products page
│       │   │   ├── CartPage.java              # Cart page
│       │   │   ├── CheckoutPage.java          # Checkout page
│       │   │   └── SignupFormPage.java        # Registration form
│       │   ├── tests/
│       │   │   ├── LoginTest.java             # Test Case 2
│       │   │   ├── RegisterTest.java          # Test Case 1
│       │   │   └── CheckoutTest.java          # Test Case 16
│       │   ├── utils/
│       │   │   ├── ScreenshotUtils.java      # Screenshot handling
│       │   │   └── TestData.java             # Test data
│       └── resources/
│           ├── log4j2.xml                    # Logging configuration
│           └── testng.xml                   # TestNG suite
├── pom.xml                                 # Maven configuration
└── README.md                               # Project documentation
```

## ▶️ How to Run

## Run all tests:

```
mvn clean test
```

## Or using TestNG suite:

testng.xml

## 📸 Evidence

Execution generates:

- PASS Tests Screenshots in /evidence
- NOT PASS Tests Screenshots in /screenshots
- Logs in /logs/test-execution.log

# 👨‍💻 Author

**Student:** Ulises Lara  
**Program:** EPAM Java Automation Specialization  
**Project:** Module 7 Task Selenium WebDriver
**Date:** March 2026








