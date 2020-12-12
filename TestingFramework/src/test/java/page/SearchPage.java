package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='item-block_name item-block_name--tile']")
    WebElement firstItemName;

    public SearchPage (WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }

    protected SearchPage openPage() {
        throw new RuntimeException("Cannot open SearchPage without context!");
    }
}
