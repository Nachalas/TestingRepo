import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAddToDesired {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPresenceAfterAddingToDesired() {
        driver.get("https://7745.by/product/366801");
        String expectedName = driver.findElement(By.xpath("//h1[@class='product__title product__title--small-mt js-prod-title']")).getText();
        WebElement addToDesiredButton = driver.findElement(By.xpath("//div[@class='action-btn js-favorites-toggle action-btn--favourites-product action-btn--favourites']"));
        addToDesiredButton.click();
        (new WebDriverWait(driver, 10)).until(CustomConditions.textNotEmpty());
        driver.get("https://7745.by/favorites");
        List<WebElement> goodsAtDesiredPage = driver.findElements(By.xpath("//div[@class='catalog-item__wrapper']"));
        String firstDesiredName = goodsAtDesiredPage.get(0).findElement(By.xpath("//a[@class='item-block_name item-block_name--tile']")).getText();
        Assert.assertEquals(expectedName, firstDesiredName);
    }

    @Test
    public void testChangeOfCounterAfterAdding() {
        driver.get("https://7745.by/product/366801");
        WebElement addToDesiredButton = driver.findElement(By.xpath("//div[@class='action-btn js-favorites-toggle action-btn--favourites-product action-btn--favourites']"));
        addToDesiredButton.click();
        (new WebDriverWait(driver, 10)).until(CustomConditions.textNotEmpty());
        WebElement favCountSpan = driver.findElement(By.xpath("//span[@data-pl-favorite-count]"));
        Assert.assertEquals(1, Integer.parseInt(favCountSpan.getText()));
    }

    @AfterMethod(alwaysRun = true)
    public void closeSession() {
        driver.quit();
        driver = null;
    }

}
