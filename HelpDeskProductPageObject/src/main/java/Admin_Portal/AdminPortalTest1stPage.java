package Admin_Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverbase.AppPage;

/**
 * Page object for Admin Portal's status and priority management.
 */
public class AdminPortalTest1stPage extends AppPage {

    private static final int TIMEOUT = 10;
    private WebDriverWait wait;

    public AdminPortalTest1stPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    @FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
    private WebElement title;

    @FindBy(linkText = "Statuses")
    private WebElement statuses;

    /**
     * Navigates to the Statuses section.
     */
    public void clickStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(title));
        hoverOverElementUsingJS(title);
        title.click();
        wait.until(ExpectedConditions.elementToBeClickable(statuses));
        statuses.click();
    }

    @FindBy(linkText = "Priorities")
    private WebElement priorities;

    /**
     * Navigates to the Priorities section.
     */
    public void clickPriorities() {
        wait.until(ExpectedConditions.elementToBeClickable(title));
        hoverOverElementUsingJS(title);
        title.click();
        wait.until(ExpectedConditions.elementToBeClickable(priorities));
        hoverOverElementUsingJS(priorities);
        priorities.click();
    }

    @FindBy(xpath = "//button[@class='hf-mod-create']")
    private WebElement newStatus;

    public void clickNewStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        newStatus.click();
    }

    @FindBy(xpath = "//input[@aria-label='Status Name']")
    private WebElement statusName;

    public void enterStatusName(String text) {
        wait.until(ExpectedConditions.visibilityOf(statusName));
        statusName.sendKeys(text);
    }

    @FindBy(xpath = "//div[@class='sp-preview-inner']")
    private WebElement statusColourInner;

    public void clickStatusColourInner() {
        wait.until(ExpectedConditions.elementToBeClickable(statusColourInner));
        statusColourInner.click();
    }

    @FindBy(xpath = "//input[@placeholder='Enter any valid color code format.']")
    private WebElement statusColour;

    public void enterStatusColour(String text) {
        clickStatusColourInner();
        wait.until(ExpectedConditions.visibilityOf(statusColour));
        statusColour.clear();
        statusColour.sendKeys(text);
        clickStatusColourInner();
    }

    @FindBy(xpath = "//div[@aria-label='Behavior']")
    private WebElement behavior;

    public void enterBehavior(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(behavior));
        behavior.click();
        behavior.sendKeys(text);
        behavior.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//textarea[@aria-label='Description']")
    private WebElement statusDescription;

    public void enterStatusDescription(String text) {
        wait.until(ExpectedConditions.visibilityOf(statusDescription));
        statusDescription.clear();
        statusDescription.sendKeys(text);
    }

    @FindBy(xpath = "//button[@data-test-id='add-status']")
    private WebElement addStatus;

    public void clickAddStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(addStatus));
        addStatus.click();
    }

    @FindBy(xpath = "//a[@data-test-id='manage-statuses-left-nav']")
    private WebElement statusesSection;

    public void clickStatusesSection() {
        wait.until(ExpectedConditions.elementToBeClickable(statusesSection));
        scrolltoElement(statusesSection);
        statusesSection.click();
    }

    /**
     * Sets the given status as default by its visible text.
     */
    public void setDefaultStatus(String statusText) {
        String statusXpath = "//div[contains(text(),'" + statusText + "')]//following::td[3]";
        WebElement statusElem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(statusXpath))));
        hoverOverElementUsingJS(statusElem);
        statusElem.click();
    }

    @FindBy(xpath = "//a[contains(text(),'Priorities')]")
    private WebElement prioritySection;

    public void clickPrioritySection() {
        wait.until(ExpectedConditions.elementToBeClickable(prioritySection));
        prioritySection.click();
    }

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")
    private WebElement newPriority;

    public void clickNewPriority() {
        wait.until(ExpectedConditions.elementToBeClickable(newPriority));
        newPriority.click();
    }

    @FindBy(xpath = "//input[@data-test-id='form-field-name']")
    private WebElement priorityName;

    public void enterPriorityName(String text) {
        wait.until(ExpectedConditions.visibilityOf(priorityName));
        priorityName.clear();
        priorityName.sendKeys(text);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")
    private WebElement priorityDescription;

    public void enterPriorityDescription(String text) {
        wait.until(ExpectedConditions.visibilityOf(priorityDescription));
        priorityDescription.clear();
        priorityDescription.sendKeys(text);
    }

    @FindBy(xpath = "//textarea[@data-test-id='form-field-helpText']")
    private WebElement priorityHelpText;

    public void enterPriorityHelpText(String text) {
        wait.until(ExpectedConditions.visibilityOf(priorityHelpText));
        priorityHelpText.clear();
        priorityHelpText.sendKeys(text);
    }

    @FindBy(xpath = "//button[@data-test-id='add-priority']")
    private WebElement addPriority;

    public void clickAddPriority() {
        wait.until(ExpectedConditions.elementToBeClickable(addPriority));
        addPriority.click();
    }

    /**
     * Sets the given priority as default by its visible text.
     */
    public void setDefaultPriroity(String priorityText) {
        String priorityXpath = "//span[contains(text(),'" + priorityText + "')]//following::td[3]";
        WebElement priorityElem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(priorityXpath))));
        hoverOverElementUsingJS(priorityElem);
        priorityElem.click();
    }

    /**
     * Clicks the added priority by its visible text.
     */
    public void clickAddedPriority(String priorityText) {
        String priorityXpath = "//span[contains(text(),'" + priorityText + "')]";
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(priorityXpath))));
        scrolltoElement(priorityXpath);
        elem.click();
    }

    @FindBy(xpath = "//a[@data-test-id='priority-delete-trigger']")
    private WebElement priorityDeleteLink;

    public void clickPriorityDeleteLink() {
        wait.until(ExpectedConditions.elementToBeClickable(priorityDeleteLink));
        scrolltoElement(priorityDeleteLink);
        priorityDeleteLink.click();
    }

    @FindBy(xpath = "//button[@data-test-id='delete-dependants-primary-action']")
    private WebElement deleteConfirm;

    public void clickDeleteConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirm));
        deleteConfirm.click();
    }

    /**
     * Clicks the added status by its visible text.
     */
    public void clickAddedStatus(String statusText) {
        String statusXpath = "//div[contains(text(),'" + statusText + "')]";
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(statusXpath))));
        scrolltoElement(statusXpath);
        elem.click();
    }

    @FindBy(xpath = "//a[@data-test-id='status-delete-trigger']")
    private WebElement statusDeleteLink;

    public void clickStatusDeleteLink() {
        wait.until(ExpectedConditions.elementToBeClickable(statusDeleteLink));
        scrolltoElement(statusDeleteLink);
        statusDeleteLink.click();
    }

    @FindBy(xpath = "//div[@class='hf-avatar-image-container ember-view']//img[@class='hf-avatar-image hf-avatar-image_show']")
    private WebElement profile;

    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        waitForVisible(profile);
        profile.click();
    }

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }
}
