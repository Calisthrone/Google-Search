package Test;

import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{

    @Test
    public void assignmentTest() {

        googlePage
                .gotoGooglePage()
                .searchFor("Cute cats")
                .switchToVerbatim()
                .extractResults(3);
    }
}