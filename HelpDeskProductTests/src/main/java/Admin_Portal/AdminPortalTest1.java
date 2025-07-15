package Admin_Portal;

import org.testng.annotations.Test;
import CommonTests.CommonTests1;

/**
 * Test for Scenario 1: Login, create status/priority, delete them, and logout.
 */
public class AdminPortalTest1 extends CommonTests1 {

    @Test
    public void scenario1() {
        loginAsAdmin();
        createAndSetDefaultStatusAndPriority();
        deleteStatusPriorityAndLogout();
    }
}
 