package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AuthPage;

public class AuthSteps {

    private final AuthPage authPage;

    public AuthSteps(WebDriver driver) {
        this.authPage = new AuthPage(driver);
    }

    @Step("Leave auth form credentials empty")
    public void leaveCredentialsEmpty() {
        fillCredentials("", "");
    }

    @Step("Fill auth form with only username")
    public void fillUsernameOnly(String username) {
        fillCredentials(username, "");
    }

    @Step("Fill auth form with only password")
    public void fillPasswordOnly(String password) {
        fillCredentials("", password);
    }

    @Step("Submit auth form with invalid username and password")
    public void submitInvalidLogin(String username, String password) {
        fillAndSubmit(username, password);
    }

    @Step("Verify login button is disabled")
    public boolean isLoginButtonDisabled() {
        return authPage.waitUntilLoginButtonDisabled();
    }

    private void fillAndSubmit(String username, String password) {
        fillCredentials(username, password);
        authPage.submitLoginForm();
    }

    private void fillCredentials(String username, String password) {
        authPage.enterUsername(username);
        authPage.enterPassword(password);
    }

    @Step("Verify authorization error is displayed")
    public boolean isAuthorizationErrorDisplayed() {
        return authPage.isErrorMessageDisplayed();
    }
}
