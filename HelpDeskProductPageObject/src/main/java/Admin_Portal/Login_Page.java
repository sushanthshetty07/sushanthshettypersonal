package Admin_Portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverbase.AppPage;

/**
 * Page object for the login page of the Admin Portal.
 */
public class Login_Page extends AppPage {

    private static final int TIMEOUT = 10;
    private WebDriverWait wait;

    public Login_Page(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(linkText = "Forgot password?")
    private WebElement forgotPasswordLink;

    /**
     * Navigates to the HappyFox Admin Portal login page.
     */
    public void navigateToHappyFoxHomePageURL(String url) {
        driver.get(url);
    }

    /**
     * Enters the username.
     */
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    /**
     * Enters the password.
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    /**
     * Clicks the forgot password link.
     */
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
    }

    // Add any additional methods actually used by the tests, e.g.:
    public AdminPortalTest1stPage validatePendingTicketsTitle() {
        // Implementation for navigation/validation after login
        // (Stub: replace with actual logic as needed)
        return new AdminPortalTest1stPage(driver);
    }

    public void validatePendingTicketsTitle1() {
        // Implementation for navigation/validation after ticket creation
        // (Stub: replace with actual logic as needed)
    }
}
