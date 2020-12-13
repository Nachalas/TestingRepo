package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final Logger logger = LogManager.getRootLogger();
    private static final String addToCartButtonXPath = "//div[@class='controls-bl controls-bl--flex']/button";

    private By comparisonButtonLocator = By.xpath("//div[@class='action-btn action-btn--compare-in-card do-compare  compare-in just-added']");
    private By placeOfDeliveryNameLocator = By.xpath("//div[@class='card--container card--container__delivery']/div[@class='center-block']/div[@class='center-block--content center-block--address']");

    @FindBy(xpath = "//div[@class='action-btn js-favorites-toggle action-btn--favourites-product action-btn--favourites']")
    private WebElement addToFavouritesButton;

    @FindBy(xpath = "//span[@data-pl-favorite-count]")
    private WebElement favouriteCountSpan;

    @FindBy(xpath = "//span[@data-pl-viewed-count]")
    private WebElement viewedCountSpan;

    @FindBy(xpath = "//h1[@class='product__title product__title--small-mt js-prod-title']")
    private WebElement productName;

    @FindBy(xpath = addToCartButtonXPath)
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@class='open-popup icon-city d-flex']")
    private WebElement openChangePODDialog;

    @FindBy(xpath = "//input[@class='form-control ui-autocomplete-input set-locality-id']")
    private WebElement changePODInput;

    @FindBy(xpath = "//button[@class='btn btn-orange']")
    private WebElement submitPODChangeButton;

    @FindBy(xpath = "//div[@class='card--container card--container__delivery']/div[@class='center-block']/div[@class='center-block--content center-block--address']")
    private WebElement placeOfDeliveryName;

    @FindBy(xpath = "//span[@class='item-block_text']")
    private WebElement addToComparisonButton;

    @FindBy(xpath = "//table[@class='features']/tbody/tr[not(@class)]/td[1]")
    private List<WebElement> itemCharacteristicsNames;

    @FindBy(xpath = "//table[@class='features']/tbody/tr[not(@class)]/td[2]")
    private List<WebElement> itemCharacteristics;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url;
    }

    @Override
    public ProductPage openPage() {
        driver.get(itemPageURL);
        logger.info("Opened page " + itemPageURL);
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-viewed-count]"));
        return this;
    }

    public ProductPage addItemToDesired() {
        addToFavouritesButton.click();
        logger.info("Added item to desired");
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(CustomConditions.textNotEmpty("//span[@data-pl-favorite-count]"));
        return this;
    }

    public ProductPage addItemToComparison() {
        addToComparisonButton.click();
        logger.info("Added item to comparison");
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(comparisonButtonLocator));
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
        logger.info("Changed place of delivery to " + place);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getPlaceOfDelivery() {
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(
                ExpectedConditions.presenceOfElementLocated(placeOfDeliveryNameLocator));
        return placeOfDeliveryName.getText();
    }

    public ProductPage addItemToCart() {
        addToCartButton.click();
        logger.info("Added item to cart");
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
        logger.info("Opening favorites page");
        driver.get("https://7745.by/favorites");
        return new DesiredPage(driver);
    }
}
