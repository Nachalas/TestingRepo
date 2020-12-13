package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CustomConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends AbstractPage {

    private String itemPageURL;

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

    @FindBy(xpath = "//input[@class='open-popup icon-city d-flex']")
    WebElement openChangePODDialog;

    @FindBy(xpath = "//input[@class='form-control ui-autocomplete-input set-locality-id']")
    WebElement changePODInput;

    @FindBy(xpath = "//button[@class='btn btn-orange']")
    WebElement submitPODChangeButton;

    @FindBy(xpath = "//div[@class='card--container card--container__delivery']/div[@class='center-block']/div[@class='center-block--content center-block--address']")
    WebElement placeOfDeliveryName;

    @FindBy(xpath = "//span[@class='item-block_text']")
    WebElement addToComparisonButton;

    @FindBy(xpath = "//table[@class='features']/tbody/tr[not(@class)]/td[1]")
    List<WebElement> itemCharacteristicsNames;

    @FindBy(xpath = "//table[@class='features']/tbody/tr[not(@class)]/td[2]")
    List<WebElement> itemCharacteristics;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url;
    }

    @Override
    public ProductPage openPage() {
        driver.get(itemPageURL);
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-viewed-count]"));
        return this;
    }

    public ProductPage addItemToDesired() {
        addToFavouritesButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-favorite-count]"));
        return this;
    }

    public ProductPage addItemToComparison() {
        addToComparisonButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='action-btn action-btn--compare-in-card do-compare  compare-in just-added']")));
        return this;
    }

    public List<String> getItemCharacteristicsNames() {
        List<String> toReturn = new ArrayList<>();
        for(WebElement elem : itemCharacteristicsNames) {
            toReturn.add(elem.getText());
        }
        return toReturn;
    }

    public List<String> getItemCharacteristics() {
        List<String> toReturn = new ArrayList<>();
        for(WebElement elem : itemCharacteristics) {
            toReturn.add(elem.getText());
        }
        return toReturn;
    }

    public ProductPage changePlaceOfDelivery(String place) {
        openChangePODDialog.click();
        changePODInput.sendKeys(Keys.CONTROL + "a");
        changePODInput.sendKeys(Keys.DELETE);
        changePODInput.sendKeys(place);
        WebElement firstOption = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='ui-menu-item']")));
        firstOption.click();
        submitPODChangeButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getPlaceOfDelivery() {
        return placeOfDeliveryName.getText();
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
