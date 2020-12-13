package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://7745.by/";
	private final Logger logger = LogManager.getRootLogger();

	private By usernameFieldLocator = By.xpath("//div[@id='logon-link']/span[@class='text username']");

	@FindBy (xpath = "//a[@href='/profile']")
	private WebElement logInButton;

	@FindBy (xpath = "//input[@id='login-modal-input-name']")
	private WebElement loginInput;

	@FindBy (xpath = "//input[@id='edit-pass-1']")
	private WebElement passwordInput;

	@FindBy (xpath = "//input[@id='edit-submit-1']")
	private WebElement logInSubmitButton;

	@FindBy (xpath = "//input[@class='ui-autocomplete-input']")
	private WebElement searchBarInput;

	@FindBy (xpath = "//button[@class='btn btn-search']")
	private WebElement searchBarButton;

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	public SearchPage searchForQuery(String query) {
		searchBarInput.sendKeys(query);
		searchBarButton.click();
		logger.info("Searching for " + query);
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
						presenceOfElementLocated(usernameFieldLocator));
		return this;
	}

	@Override
	public MainPage openPage()
	{
		driver.get(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}
}
