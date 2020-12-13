package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage  {
    private String itemPageURL;

    @FindBy(xpath = "//button[@class='btn btn-orange' and @type='submit']")
    WebElement applyFilterButton;

    @FindBy(xpath = "//a[@class='item-block_name item-block_name--tile']")
    WebElement firstItemName;

    public CatalogPage(WebDriver driver, String url) {
        super(driver);
        itemPageURL = url;
    }

    @Override
    public CatalogPage openPage() {
        driver.get(itemPageURL);
        return this;
    }

    public CatalogPage applyManufacturerFilter(String manufacturer) {
        WebElement checkbox = driver.findElement(By.xpath("//span[@class='catalog-filter__checkbox-text' and contains(text(), '" + manufacturer + "')]"));
        checkbox.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-orange' and @type='submit']")));
        applyFilterButton.click();
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='catalog-item__wrapper']")));
        return this;
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }
}
