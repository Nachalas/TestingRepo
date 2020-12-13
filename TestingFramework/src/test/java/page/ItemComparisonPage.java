package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CustomConditions;

import java.util.ArrayList;
import java.util.List;

public class ItemComparisonPage extends AbstractPage  {
    private final String BASE_URL = "https://7745.by/compare";

    @FindBy (xpath = "//ul[@class='height-3']/li")
    List<WebElement> itemCharacteristicsNames;

    @FindBy (xpath = "//ul[@class='compare-bbl-list height-3']/li")
    List<WebElement> itemCharacteristics;

    @FindBy (xpath = "//a[@class='si-name']")
    WebElement firstItemName;

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
        return this;
    }
}
