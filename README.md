# Hepsiburada Selenium UI Test Automation Framework

This project is a UI test automation framework developed for the Hepsiburada e-commerce website using Selenium WebDriver. The main goal is to automate and validate core user flows such as login and page interactions.

---

## 🚀 Technologies Used

* Java
* Selenium WebDriver
* Maven
* TestNG / JUnit 
* Page Object Model (POM)

---

## 📁 Project Structure

```text
hepsiburada-selenium-tests/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           └── Main.java
│   │
│   └── test/
│       └── java/
│           ├── pages/
│           │   ├── BasePage.java
│           │   ├── LoginPage.java
│           │   └── MainPage.java
│           │
│           └── tests/
│               └── LoginTests.java
│
├── pom.xml
└── .gitignore

## 🧪 Test Scenarios

The following test scenarios are automated in this project:

* User login functionality
* Product search functionality

* (Add more scenarios if available)

---

## ⚙️ Setup Instructions

Clone the repository:

```bash id="g7k2pm"
git clone https://github.com/your-username/hepsiburada-selenium-tests.git
```

Navigate to the project directory:

```bash id="q8m2dn"
cd hepsiburada-selenium-tests
```

---

## ▶️ Running Tests

Run tests using Maven:

```bash id="v3k9sd"
mvn test
```

---

## 📌 Notes

* `.idea`, `target`, and `.iml` files are excluded via `.gitignore`.
* The framework is designed using the Page Object Model (POM) for better maintainability.
* Tests are independent and reusable.

---

## 🚀 Future Improvements

* Add test reporting (Extent Reports / Allure)
* Capture screenshots on failure
* Parallel test execution
* CI/CD integration (GitHub Actions)
* Data-driven testing implementation

---

## 👤 Author

This project was created for learning and portfolio purposes to demonstrate UI test automation skills using Selenium WebDriver.
