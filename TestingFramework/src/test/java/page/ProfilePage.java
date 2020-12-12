package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {

    @FindBy (xpath = "//input[@name='profile[user][mail]']")
    WebElement userEmailField;

    private final String BASE_URL = "https://7745.by/profile";

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
        return this;
    }
}
