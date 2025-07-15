package Admin_Portal;

import org.testng.annotations.Test;
import CommonTests.CommonTests1;

/**
 * Test for Scenario 2: Login, create status/priority, verify ticket, reply, delete, and logout.
 */
public class AdminPortalTest2 extends CommonTests1 {

    @Test
    public void scenario2() {
        loginAsAdmin();
        createAndSetDefaultStatusAndPriority();
        verifyTicketDefaultStatusPriorityAndReply();
        deleteStatusPriorityAndLogout();
    }
}
