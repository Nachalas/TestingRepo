package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewedPage extends AbstractPage {
    private static final String ITEM_PAGE_URL = "https://7745.by/viewed";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//a[@class='item-block_name item-block_name--tile']")
    private WebElement firstItemName;

    public String getFirstItemName() {
        return firstItemName.getText();
    }

    public ViewedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ViewedPage openPage() {
        driver.get(ITEM_PAGE_URL);
        logger.info("Opened page " + ITEM_PAGE_URL);
        return this;
    }
}
