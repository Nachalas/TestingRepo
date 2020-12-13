package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ItemComparisonPage extends AbstractPage  {
    private final String BASE_URL = "https://7745.by/compare";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//ul[@class='height-3']/li")
    private List<WebElement> itemCharacteristicsNames;

    @FindBy (xpath = "//ul[@class='compare-bbl-list height-3']/li")
    private List<WebElement> itemCharacteristics;

    @FindBy (xpath = "//a[@class='si-name']")
    private WebElement firstItemName;

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

    public String getFirstItemName() {
        return firstItemName.getText();
    }

    public ItemComparisonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ItemComparisonPage openPage() {
        driver.get(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }
}
