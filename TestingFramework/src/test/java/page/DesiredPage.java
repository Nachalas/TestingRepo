package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesiredPage extends AbstractPage {
    private static final String ITEM_PAGE_URL = "https://7745.by/favorites";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@class='item-block_name item-block_name--tile']")
    private WebElement firstDesiredItem;

    public DesiredPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DesiredPage openPage() {
        driver.get(ITEM_PAGE_URL);
        logger.info("Opened page " + ITEM_PAGE_URL);
        return this;
    }

    public String getFirstItemName() {
        return firstDesiredItem.getText();
    }
}
