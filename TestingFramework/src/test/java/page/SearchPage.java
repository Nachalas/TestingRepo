package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@class='item-block_name item-block_name--tile']")
    private WebElement firstItemName;

    public SearchPage (WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }

    @Override
    protected SearchPage openPage() {
        logger.error("Cannot open SearchPage without context!");
        throw new RuntimeException("Cannot open SearchPage without context!");
    }
}
