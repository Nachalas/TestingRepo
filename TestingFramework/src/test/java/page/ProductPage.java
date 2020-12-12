package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CustomConditions;

public class ProductPage extends AbstractPage {

    private String ITEM_PAGE_URL;

    private static final String addToCartButtonXPath = "//div[@class='controls-bl controls-bl--flex']/button";

    @FindBy(xpath = "//div[@class='action-btn js-favorites-toggle action-btn--favourites-product action-btn--favourites']")
    WebElement addToFavouritesButton;

    @FindBy(xpath = "//span[@data-pl-favorite-count]")
    WebElement favouriteCountSpan;

    @FindBy(xpath = "//span[@data-pl-viewed-count]")
    WebElement viewedCountSpan;

    @FindBy(xpath = "//h1[@class='product__title product__title--small-mt js-prod-title']")
    WebElement productName;

    @FindBy(xpath = addToCartButtonXPath)
    WebElement addToCartButton;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        ITEM_PAGE_URL = url;
    }

    @Override
    public ProductPage openPage() {
        driver.get(ITEM_PAGE_URL);
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-viewed-count]"));
        return this;
    }

    public ProductPage addItemToDesired() {
        addToFavouritesButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-favorite-count]"));
        return this;
    }

    public ProductPage addItemToCart() {
        addToCartButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.attributeToBe(
                        By.xpath(addToCartButtonXPath),
                        "class",
                        "btn btn-lite-grey btn-buy ordered btn-buy_padding"));
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getFavouriteItemsCount() {
        return Integer.parseInt(favouriteCountSpan.getText());
    }

    public int getViewedItemsCount() {
        return Integer.parseInt(viewedCountSpan.getText());
    }

    public DesiredPage openFavouritesPage() {
        driver.get("https://7745.by/favorites");
        return new DesiredPage(driver);
    }
}
