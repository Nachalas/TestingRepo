package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy (xpath = "//input[@class='ui-autocomplete-input']")
	WebElement searchBarInput;

	@FindBy (xpath = "//button[@class='btn btn-search']")
	WebElement searchBarButton;

	private final String BASE_URL = "https://7745.by/";

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	public SearchPage searchForQuery(String query) {
		searchBarInput.sendKeys(query);
		searchBarButton.click();
		return new SearchPage(driver);
	}

	public MainPage openLogInDialog() {
		logInButton.click();
		return this;
	}

	public MainPage logIn(User user) {
		loginInput.sendKeys(user.getUsername());
		passwordInput.sendKeys(user.getPassword());
		logInSubmitButton.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
				until(ExpectedConditions.
						presenceOfElementLocated(By.xpath("//div[@id='logon-link']/span[@class='text username']")));
		return this;
	}



	@Override
	public MainPage openPage()
	{
		driver.get(BASE_URL);
		return this;
	}
}
