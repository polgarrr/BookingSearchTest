package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By CITY_NAME = By.cssSelector("[class='c-autocomplete__input.sb-searchbox__input.sb-destination__input']");
    private final By DATE_PICKER = By.cssSelector("[class='xp__dates-inner']");
    private final By GUEST = By.cssSelector("[id='xp__guests__toggle']");
    private final By ADULT = By.cssSelector("[aria-describedby='group_adults_desc']");
    private final By SEARCH = By.cssSelector("[class='sb-searchbox__button ']");

    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage enterCityName(String city) {
        $(CITY_NAME).sendKeys(city);
        return this;
    }

    public HomePage chooseDate() {
        $(DATE_PICKER).click();
        $(DATE_PICKER).shouldBe(Condition.visible).findElement(By.cssSelector("td"));
        $(DATE_PICKER).findElement(By.cssSelector("td"));
        return this;
    }

    public HomePage enterGuest() {
        $(GUEST).click();
        $(ADULT).click();
        return this;
    }

    public HomePage clickSearch() {
        $(SEARCH).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
}
