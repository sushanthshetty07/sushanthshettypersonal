package CommonTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Admin_Portal.AdminPortalTest1stPage;
import Admin_Portal.AdminPortalTest2ndPage;
import Admin_Portal.Login_Page;
import CustomerPortal.SupportPortalPage;
import webdriverbase.BaseTest;

/**
 * Common test steps and scenarios for HappyFox automation.
 */
public class CommonTests1 extends BaseTest {

    // Test data and configuration loaded from properties
    private static final String ADMIN_PORTAL_URL = ConfigLoader.get("admin.portal.url");
    private static final String SUPPORT_TICKET_URL = ConfigLoader.get("support.ticket.url");
    private static final String BROWSER = ConfigLoader.get("browser");
    private static final String USERNAME = ConfigLoader.get("username");
    private static final String PASSWORD = ConfigLoader.get("password");
    private static final String STATUS_NAME = ConfigLoader.get("status.name");
    private static final String PRIORITY_NAME = ConfigLoader.get("priority.name");
    private static final String SUBJECT = ConfigLoader.get("subject");
    private static final String MESSAGE = ConfigLoader.get("message");
    private static final String FULL_NAME = ConfigLoader.get("full.name");
    private static final String EMAIL = ConfigLoader.get("email");

    // Page objects
    protected Login_Page loginPage;
    protected SupportPortalPage supportPortalPage;
    protected AdminPortalTest1stPage adminPortalPage1;
    protected AdminPortalTest2ndPage adminPortalPage2;

    /**
     * Logs in as admin user.
     */
    public void loginAsAdmin() {
        try {
            loginPage = new Login_Page(getDriver());
            loginPage.navigateToHappyFoxHomePageURL(ADMIN_PORTAL_URL);
            loginPage.enterUsername(USERNAME);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickLoginbutton();
            adminPortalPage1 = loginPage.validatePendingTicketsTitle();
        } catch (Throwable t) {
            Assert.fail("Error in loginAsAdmin: " + t.getMessage(), t);
        }
    }

    /**
     * Creates a support ticket from the support portal.
     */
    public void createSupportTicket() {
        try {
            supportPortalPage = new SupportPortalPage(getDriver());
            supportPortalPage.navigateToHappyFoxSupportPortalURL(SUPPORT_TICKET_URL);
            supportPortalPage.enterSubject(SUBJECT);
            supportPortalPage.enterMessage(MESSAGE);
            supportPortalPage.clickAddCC();
            supportPortalPage.clickAddBCC();
            supportPortalPage.enterFullName(FULL_NAME);
            supportPortalPage.enterEmail(EMAIL);
            adminPortalPage2 = supportPortalPage.clickCreateTicket();
            adminPortalPage2.gotoAgentPortal();
        } catch (Throwable t) {
            Assert.fail("Error in createSupportTicket: " + t.getMessage(), t);
        }
    }

    /**
     * Creates a new status and priority, and sets them as default.
     */
    public void createAndSetDefaultStatusAndPriority() {
        try {
            adminPortalPage1 = loginPage.validatePendingTicketsTitle();
            adminPortalPage1.clickStatus();
            adminPortalPage1.clickNewStatus();
            adminPortalPage1.enterStatusName(STATUS_NAME);
            // adminPortalPage1.enterStatusColour("#21d0d5"); // Optional: set color
            adminPortalPage1.enterBehavior("Pending");
            adminPortalPage1.enterStatusDescription("Status when a new issue ticket is created in HappyFox");
            adminPortalPage1.clickAddStatus();
            adminPortalPage1.setDefaultStatus(STATUS_NAME);
            adminPortalPage1.clickPrioritySection();
            adminPortalPage1.clickNewPriority();
            adminPortalPage1.enterPriorityName(PRIORITY_NAME);
            adminPortalPage1.enterPriorityDescription("Priority of the newly created tickets");
            adminPortalPage1.enterPriorityHelpText("priority helptext");
            adminPortalPage1.clickAddPriority();
            adminPortalPage1.setDefaultPriroity(PRIORITY_NAME);
        } catch (Throwable e) {
            Assert.fail("Error in createAndSetDefaultStatusAndPriority: " + e.getMessage(), e);
        }
    }

    /**
     * Verifies ticket has default status and priority, replies using canned action, and checks updates.
     */
    public void verifyTicketDefaultStatusPriorityAndReply() {
        try {
            createSupportTicket();
            loginPage.validatePendingTicketsTitle1();
            adminPortalPage2.clickPendingTickets();
            adminPortalPage2.openCustomerTicket(SUBJECT);
            // Assert ticket details
            Assert.assertEquals(adminPortalPage2.getContactName(), "Aravind", "Contact name mismatch");
            Assert.assertEquals(adminPortalPage2.getEmailtxt(), EMAIL, "Email mismatch");
            adminPortalPage2.clickReplyButton();
            Assert.assertEquals(adminPortalPage2.getStatustxt(), STATUS_NAME, "Status mismatch");
            Assert.assertEquals(adminPortalPage2.getPrioritytxt(), PRIORITY_NAME.toUpperCase(), "Priority mismatch");
            // Reply using canned action
            adminPortalPage2.clickCannedAction();
            adminPortalPage2.clickSearchCannedAction("Reply to Customer Query");
            adminPortalPage2.clickApplyCannedAction();
            // Assert after reply
            Assert.assertEquals(adminPortalPage2.getStatustxt(), "Closed", "Status after reply mismatch");
            Assert.assertEquals(adminPortalPage2.getPrioritytxt(), "Medium", "Priority after reply mismatch");
            adminPortalPage2.sendReply();
            adminPortalPage1 = adminPortalPage2.closeTheTicket();
            adminPortalPage1.clickPriorities();
        } catch (Throwable t) {
            Assert.fail("Error in verifyTicketDefaultStatusPriorityAndReply: " + t.getMessage(), t);
        }
    }

    /**
     * Deletes the created status and priority, logs out, and quits the browser.
     */
    public void deleteStatusPriorityAndLogout() {
        try {
            adminPortalPage1.setDefaultPriroity("Low");
            adminPortalPage1.clickAddedPriority(PRIORITY_NAME);
            adminPortalPage1.clickPriorityDeleteLink();
            adminPortalPage1.clickDeleteConfirm();
            adminPortalPage1.clickStatusesSection();
            adminPortalPage1.setDefaultStatus("New");
            adminPortalPage1.clickAddedStatus(STATUS_NAME);
            adminPortalPage1.clickStatusDeleteLink();
            adminPortalPage1.clickDeleteConfirm();
            adminPortalPage1.clickProfile();
            adminPortalPage1.clickLogout();
        } catch (Throwable e) {
            Assert.fail("Error in deleteStatusPriorityAndLogout: " + e.getMessage(), e);
        }
    }
}
