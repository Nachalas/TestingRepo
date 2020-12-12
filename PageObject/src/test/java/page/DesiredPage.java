package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesiredPage extends AbstractPage {
    @FindBy (xpath = "//a[@class='item-block_name item-block_name--tile']")
    WebElement firstDesiredItem;

    private static final String ITEM_PAGE_URL = "https://7745.by/favorites";

    public DesiredPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DesiredPage openPage() {
        driver.get(ITEM_PAGE_URL);
        return this;
    }

    public String getFirstItemName() {
        return firstDesiredItem.getText();
    }
}
