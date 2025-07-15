package CustomerPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Admin_Portal.AdminPortalTest2ndPage;
import webdriverbase.AppPage;

/**
 * Page object for the Support Portal ticket creation page.
 */
public class SupportPortalPage extends AppPage {

    private static final int TIMEOUT = 10;
    private WebDriverWait wait;

    public SupportPortalPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    /**
     * Navigates to the HappyFox Support Portal ticket creation page.
     */
    public void navigateToHappyFoxSupportPortalURL(String url) {
        driver.get(url);
    }

    @FindBy(id = "id_subject")
    private WebElement subject;

    public void enterSubject(String text) {
        wait.until(ExpectedConditions.visibilityOf(subject));
        subject.sendKeys(text);
    }

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElement message;

    public void enterMessage(String text) {
        wait.until(ExpectedConditions.visibilityOf(message));
        message.sendKeys(text);
    }

    @FindBy(id = "add-cc")
    private WebElement addCC;

    public void clickAddCC() {
        wait.until(ExpectedConditions.elementToBeClickable(addCC));
        addCC.click();
    }

    @FindBy(id = "add-bcc")
    private WebElement addBCC;

    public void clickAddBCC() {
        wait.until(ExpectedConditions.elementToBeClickable(addBCC));
        addBCC.click();
    }

    @FindBy(xpath = "//input[@id='id_cc']")
    private WebElement cc;

    public void enterCC(String text) {
        wait.until(ExpectedConditions.visibilityOf(cc));
        cc.sendKeys(text);
    }

    @FindBy(xpath = "//input[@id='id_bcc']")
    private WebElement bcc;

    public void enterBCC(String text) {
        wait.until(ExpectedConditions.visibilityOf(bcc));
        bcc.sendKeys(text);
    }

    @FindBy(xpath = "//a[@class='hf-attach-file_link']")
    private WebElement browseFile;

    public void addingScreenshot(String filePath) {
        wait.until(ExpectedConditions.elementToBeClickable(browseFile));
        browseFile.sendKeys(getTestDataFullDirPath(filePath));
    }

    @FindBy(id = "id_name")
    private WebElement fullName;

    public void enterFullName(String text) {
        wait.until(ExpectedConditions.visibilityOf(fullName));
        fullName.sendKeys(text);
    }

    @FindBy(id = "id_email")
    private WebElement email;

    public void enterEmail(String text) {
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(text);
    }

    @FindBy(id = "id_phone")
    private WebElement phone;

    public void enterPhone(String text) {
        wait.until(ExpectedConditions.visibilityOf(phone));
        phone.sendKeys(text);
    }

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement createTicket;

    /**
     * Clicks the create ticket button and returns the next page object.
     */
    public AdminPortalTest2ndPage clickCreateTicket() {
        wait.until(ExpectedConditions.elementToBeClickable(createTicket));
        createTicket.click();
        return new AdminPortalTest2ndPage(driver);
    }
}
