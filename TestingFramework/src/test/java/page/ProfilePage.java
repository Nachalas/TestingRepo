package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {
    private final String BASE_URL = "https://7745.by/profile";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//input[@name='profile[user][mail]']")
    private WebElement userEmailField;

    public ProfilePage(WebDriver driver)
    {
        super(driver);
    }

    public String getUserEmailFieldText() {
        return userEmailField.getAttribute("value");
    }

    @Override
    public ProfilePage openPage()
    {
        driver.get(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }
}
