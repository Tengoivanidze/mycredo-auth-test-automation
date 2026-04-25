package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSelectorComponent {

    private final WebDriverWait wait;

    private final By languageButton = By.id("languageSwitcherBtn");

    public LanguageSelectorComponent(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By languageOptionLocator(String language) {
        return By.xpath("//div[contains(@class,'sub-language')]//p[normalize-space()='" + language + "']");
    }

    public WebElement languageButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(languageButton));
    }

    public WebElement languageOption(String language) {
        return wait.until(ExpectedConditions.elementToBeClickable(languageOptionLocator(language)));
    }
}
