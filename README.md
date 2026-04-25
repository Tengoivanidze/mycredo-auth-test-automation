# MyCredo Auth Test Automation

## Overview
Automated UI tests for MyCredo business internet banking authentication page.

Covers negative login scenarios executed across:
- ქართული
- მეგრული
- სვანური

## Tech Stack
- Java 17
- Selenium
- TestNG
- WebDriverManager
- Allure
- Maven

## Run Tests

```bash
mvn clean test
```

Default auth URL is configured in `src/main/resources/config.properties`.


## Generate Allure Reports

```bash
allure serve allure-results
```

## Clear allure reports 

```bash
rm -rf allure-results
```

## Project Structure

- `src/main/java/pages` - page objects and page components
- `src/main/resources` - environment configuration
- `src/main/java/steps` - Allure annotated business steps
- `src/main/java/utils` - shared utilities
- `src/main/java/data` - TestNG data providers and reusable test data models
- `src/test/java/base` - WebDriver setup and teardown
- `src/test/java/tests` - TestNG test classes
