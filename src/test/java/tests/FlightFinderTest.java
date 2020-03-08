package tests;

import BasePackage.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FlightFinderPage;

public class FlightFinderTest extends BaseTest {
    public static FlightFinderPage FFP;
    public static SoftAssert SA = new SoftAssert();

    @Test
    public void UserCanBook() {
        FFP = new FlightFinderPage(driver);
        FFP.BookFlight();
        FFP.hasbeenbooked();
        //SoftAssertion
        SA.assertTrue(FFP.hasbeenbooked(),"Flight not booked");
//        String conf ="Your itinerary has been booked!";
//        SA.assertEquals(conf,FFP.confirmatioText());
        String dep="Zurich to Paris";
        SA.assertEquals(dep,FFP.depart(),"Incorrect Departing");
        String ret="Paris to Zurich";
        SA.assertEquals(ret,FFP.returning(),"Incorrect Returning");
        SA.assertAll();
    }
}
