package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private final By SEARCH_CITY = By.cssSelector("[id='__bui-c638329-1']");
    private final By DATE_START = By.cssSelector("[data-testid='date-display-field-start']");
    private final By DATE_END = By.cssSelector("[data-testid='date-display-field-end']");
    private final By NIGHTS = By.cssSelector("[class='d8eab2cf7f.e2a710e162']");
    private final By GUEST_QUANTITY = By.cssSelector("[class='d47738b911']");
    private final By CARDS_QUANTITY = By.cssSelector("[class='e1f827110f.d3a14d00da']");

    public SearchPage checkSearchCity(String city) {
        $(SEARCH_CITY).shouldHave(text(city));
        return this;
    }

    public SearchPage checkDate() {
        $(DATE_START).shouldBe(visible);
        $(DATE_END).shouldBe(visible);
        $(NIGHTS).getText(); // parseInt???
        return this;
    }

    public SearchPage checkGuest() {
        $$(GUEST_QUANTITY).first().shouldHave(text("1"));
        $$(CARDS_QUANTITY).first().shouldHave(text("найдено  вариантов ___"));
        // нужно неточное сравнение либо вставка символа, означающего "любое окончание строки"

        return this;
    }

    public SearchPage checkCards() {
        $$(CARDS_QUANTITY).first().shouldHave(text(String.valueOf(sizeGreaterThan(0))));
        return this;
    }
}
