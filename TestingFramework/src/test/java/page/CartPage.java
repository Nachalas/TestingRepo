package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    private static final String ITEM_PAGE_URL = "https://7745.by/cart";

    @FindBy(xpath = "//div[@class='text text--fix-h-60']/a")
    WebElement firstDesiredItem;

    @Override
    public CartPage openPage() {
        driver.get(ITEM_PAGE_URL);
        return this;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() {
        return firstDesiredItem.getText();
    }
}
