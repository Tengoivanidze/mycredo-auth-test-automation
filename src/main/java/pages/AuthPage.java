package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {

    private final WebDriverWait wait;

    private final By usernameInput = By.id("userName");
    private final By passwordInput = By.id("newPass");
    private final By loginButton = By.id("submitAuth");
    private final By errorMessage = By.cssSelector(".toast-message, .toast, .error, .notification, .message");

    public AuthPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement usernameInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public WebElement passwordInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
    }

    public WebElement loginButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public WebElement visibleLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public WebElement errorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void enterUsername(String username) {
        fillInput(usernameInput(), username);
    }

    public void enterPassword(String password) {
        fillInput(passwordInput(), password);
    }

    public void submitLoginForm() {
        loginButton().click();
    }

    public boolean isLoginButtonEnabled() {
        return visibleLoginButton().isEnabled();
    }

    public boolean waitUntilLoginButtonDisabled() {
        try {
            return wait.until(driver -> !driver.findElement(loginButton).isEnabled());
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage().isDisplayed();
        } catch (TimeoutException exception) {
            return false;
        }
    }

    private void fillInput(WebElement input, String value) {
        input.clear();
        if (value != null && !value.isEmpty()) {
            input.sendKeys(value);
        }
    }
}
