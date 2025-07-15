package Admin_Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverbase.AppPage;

/**
 * Page object for Admin Portal's ticket actions and canned replies.
 */
public class AdminPortalTest2ndPage extends AppPage {

    private static final int TIMEOUT = 10;
    private WebDriverWait wait;

    public AdminPortalTest2ndPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    @FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
    private WebElement title;

    @FindBy(xpath = "//a[contains(text(),'Pending Tickets')]")
    private WebElement pendingTickets;

    /**
     * Navigates to the Pending Tickets section.
     */
    public void clickPendingTickets() {
        wait.until(ExpectedConditions.elementToBeClickable(pendingTickets));
        hoverOverElementUsingJS(pendingTickets);
        pendingTickets.click();
    }

    /**
     * Opens a customer ticket by its subject/title.
     */
    public void openCustomerTicket(String subject) {
        String ticketXpath = "//a[@title='" + subject + "']";
        WebElement ticketElem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ticketXpath))));
        hoverOverElementUsingJS(ticketElem);
        ticketElem.click();
    }

    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']")
    private WebElement contactName;

    public String getContactName() {
        wait.until(ExpectedConditions.visibilityOf(contactName));
        return contactName.getText();
    }

    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']//following::div[1]/div[1]/span[1]")
    private WebElement emailTxt;

    public String getEmailtxt() {
        wait.until(ExpectedConditions.visibilityOf(emailTxt));
        return emailTxt.getText();
    }

    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]")
    private WebElement statusTxt;

    public String getStatustxt() {
        wait.until(ExpectedConditions.visibilityOf(statusTxt));
        return statusTxt.getText();
    }

    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]//following::span[1]/div/div/div/div[2]")
    private WebElement priorityTxt;

    public String getPrioritytxt() {
        wait.until(ExpectedConditions.visibilityOf(priorityTxt));
        return priorityTxt.getText();
    }

    @FindBy(xpath = "//span[contains(text(),'Reply')]")
    private WebElement replyButton;

    public void clickReplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(replyButton));
        replyButton.click();
    }

    @FindBy(xpath = "//span[@data-test-id='canned-action-trigger']")
    private WebElement cannedAction;

    public void clickCannedAction() {
        wait.until(ExpectedConditions.elementToBeClickable(cannedAction));
        cannedAction.click();
    }

    @FindBy(xpath = "//input[@placeholder='Search more Canned Actions']")
    private WebElement searchCannedAction;

    @FindBy(xpath = "//li[@class='ember-power-select-option']")
    private WebElement chooseCannedAction;

    public void clickSearchCannedAction(String cannedActionText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchCannedAction));
        searchCannedAction.click();
        searchCannedAction.sendKeys(cannedActionText);
        wait.until(ExpectedConditions.elementToBeClickable(chooseCannedAction));
        chooseCannedAction.click();
    }

    @FindBy(xpath = "//button[@data-test-id='hf-add-canned-action']")
    private WebElement applyCannedAction;

    public void clickApplyCannedAction() {
        wait.until(ExpectedConditions.elementToBeClickable(applyCannedAction));
        applyCannedAction.click();
    }

    @FindBy(xpath = "//button[@data-test-id='add-update-reply-button']")
    private WebElement reply;

    public void sendReply() {
        wait.until(ExpectedConditions.elementToBeClickable(reply));
        reply.click();
    }

    @FindBy(xpath = "//a[contains(text(),'Agent Portal')]")
    private WebElement agentPortal;

    public void gotoAgentPortal() {
        wait.until(ExpectedConditions.elementToBeClickable(agentPortal));
        agentPortal.click();
    }

    @FindBy(xpath = "//a[@data-test-id='details-close']")
    private WebElement closeTicket;

    public AdminPortalTest1stPage closeTheTicket() {
        wait.until(ExpectedConditions.elementToBeClickable(closeTicket));
        closeTicket.click();
        return new AdminPortalTest1stPage(driver);
    }
}
