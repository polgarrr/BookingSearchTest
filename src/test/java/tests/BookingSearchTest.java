package tests;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.SearchPage;

public class BookingSearchTest {

    @Before
    public void searchSetup() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .enterCityName("Стамбул")
                .chooseDate()
                .enterGuest()
                .clickSearch();
    }

    @Test
    public void checkingCardsAfterSearch() {
        SearchPage searchPage = new SearchPage();
        searchPage.checkSearchCity("Стамбул")
                .checkDate()
                .checkGuest()
                .checkCards();
    }
}
