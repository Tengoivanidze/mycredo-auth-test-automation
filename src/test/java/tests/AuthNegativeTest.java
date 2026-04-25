package tests;

import base.BaseTest;
import data.AuthDataProvider;
import data.NegativeLoginCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.AuthSteps;
import steps.LanguageSteps;

@Feature("Authorization Negative Cases")
public class AuthNegativeTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test(
            dataProvider = "emptyCredentialsCases",
            dataProviderClass = AuthDataProvider.class,
            description = "Login submission is blocked when username and password are empty",
            priority = 1
    )
    public void shouldKeepLoginButtonDisabledForEmptyCredentials(NegativeLoginCase negativeLoginCase) {

        SoftAssert softAssert = new SoftAssert();
        AuthSteps authSteps = openAuthFormInLanguage(negativeLoginCase.language());

        authSteps.leaveCredentialsEmpty();

        softAssert.assertTrue(authSteps.isLoginButtonDisabled(),
                "Login button should be disabled for " + negativeLoginCase);
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(
            dataProvider = "usernameOnlyCases",
            dataProviderClass = AuthDataProvider.class,
            description = "Login submission is blocked when password is empty",
            priority = 2
    )
    public void shouldKeepLoginButtonDisabledForMissingPassword(NegativeLoginCase negativeLoginCase) {

        SoftAssert softAssert = new SoftAssert();
        AuthSteps authSteps = openAuthFormInLanguage(negativeLoginCase.language());

        authSteps.fillUsernameOnly(negativeLoginCase.username());

        softAssert.assertTrue(authSteps.isLoginButtonDisabled(),
                "Login button should be disabled for " + negativeLoginCase);
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(
            dataProvider = "passwordOnlyCases",
            dataProviderClass = AuthDataProvider.class,
            description = "Login submission is blocked when username is empty",
            priority = 3
    )
    public void shouldKeepLoginButtonDisabledForMissingUsername(NegativeLoginCase negativeLoginCase) {

        SoftAssert softAssert = new SoftAssert();
        AuthSteps authSteps = openAuthFormInLanguage(negativeLoginCase.language());

        authSteps.fillPasswordOnly(negativeLoginCase.password());

        softAssert.assertTrue(authSteps.isLoginButtonDisabled(),
                "Login button should be disabled for " + negativeLoginCase);
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(
            dataProvider = "invalidCredentialsCases",
            dataProviderClass = AuthDataProvider.class,
            description = "Authorization error is shown for invalid username and password",
            priority = 4
    )
    public void shouldShowAuthorizationErrorForInvalidCredentials(NegativeLoginCase negativeLoginCase) {

        SoftAssert softAssert = new SoftAssert();
        AuthSteps authSteps = openAuthFormInLanguage(negativeLoginCase.language());

        authSteps.submitInvalidLogin(negativeLoginCase.username(), negativeLoginCase.password());

        softAssert.assertTrue(authSteps.isAuthorizationErrorDisplayed(),
                "Error message should be displayed for " + negativeLoginCase);
        softAssert.assertAll();
    }

    private AuthSteps openAuthFormInLanguage(String language) {
        new LanguageSteps(driver).selectLanguage(language);
        return new AuthSteps(driver);
    }
}
