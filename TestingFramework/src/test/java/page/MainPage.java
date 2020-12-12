package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage
{
	@FindBy (xpath = "//a[@href='/profile']")
	WebElement logInButton;

	@FindBy (xpath = "//input[@id='login-modal-input-name']")
	WebElement loginInput;

	@FindBy (xpath = "//input[@id='edit-pass-1']")
	WebElement passwordInput;

	@FindBy (xpath = "//input[@id='edit-submit-1']")
	WebElement logInSubmitButton;

	private final String BASE_URL = "https://7745.by/";

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	public MainPage openLogInDialog() {
		logInButton.click();
		return this;
	}

	public ProfilePage logIn(User user) {
		loginInput.sendKeys(user.getUsername());
		passwordInput.sendKeys(user.getPassword());
		logInSubmitButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProfilePage(driver).openPage();
	}

	@Override
	public MainPage openPage()
	{
		driver.get(BASE_URL);
		return this;
	}
}
