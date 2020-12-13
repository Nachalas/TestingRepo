package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private static final String ITEM_PAGE_URL = "https://7745.by/cart";

    @FindBy(xpath = "//div[@class='text text--fix-h-60']/a")
    WebElement firstDesiredItem;

    @FindBy(xpath = "//input[@class='order-footer__input-promo']")
    WebElement promocodeInput;

    @FindBy(xpath = "//span[@class='order-footer__value order-footer__value--cart-bonus']")
    WebElement finalPriceString;

    @Override
    public CartPage openPage() {
        driver.get(ITEM_PAGE_URL);
        return this;
    }

    public CartPage applyPromocode(String promoCode) {
        promocodeInput.sendKeys(promoCode);
        WebElement applyPromocodeButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn js-bind-promo_submit btn-orange']")));
        String oldPrice = finalPriceString.getText();
        applyPromocodeButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).
                until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(finalPriceString, oldPrice)));
        return this;
    }

    public String getFinalPrice() {
        return finalPriceString.getText();
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() {
        return firstDesiredItem.getText();
    }
}
