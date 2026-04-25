package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.components.LanguageSelectorComponent;

public class LanguageSteps {

    private final LanguageSelectorComponent languageSelectorComponent;

    public LanguageSteps(WebDriver driver) {
        this.languageSelectorComponent = new LanguageSelectorComponent(driver);
    }

    @Step("Select language: {language}")
    public void selectLanguage(String language) {
        languageSelectorComponent.languageButton().click();
        languageSelectorComponent.languageOption(language).click();
    }
}
