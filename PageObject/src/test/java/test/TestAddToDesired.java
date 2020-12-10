package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProductPage;

public class TestAddToDesired {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void testPresenceAfterAddingToDesired() {
        String expected = "Вытяжка встраиваемая NORMANN BCH-8101.60 нержавеющая сталь (BCH-8101.60.IN)";
        String firstDesiredElement = new ProductPage(driver)
                .openPage()
                .addItemToDesired()
                .openFavouritesPage()
                .getFirstItemName();
        Assert.assertEquals(expected, firstDesiredElement);
    }

    @Test
    public void testChangeOfCounterAfterAdding() {
        int favouriteCount = new ProductPage(driver)
                .openPage()
                .addItemToDesired()
                .getFavouriteItemsCount();
        Assert.assertEquals(1, favouriteCount);
    }

    @AfterMethod(alwaysRun = true)
    public void closeSession() {
        driver.quit();
        driver = null;
    }
}
