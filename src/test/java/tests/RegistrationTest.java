package tests;

import BasePackage.BaseTest;
import com.ahmed.excelizer.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    public static RegistrationPage RP;
    public static SoftAssert SA  = new SoftAssert();

    @DataProvider(name = "datareader")
    public Object[][] userdata() {
        return ExcelReader.loadTestData(System.getProperty("user.dir") +
                "\\Data\\SiliconExcel.xlsx", "RegistrationPage");
    }

    @Test(dataProvider = "datareader")
    public void UserCanRegister(String firstname, String lastname, String phonenumber, String email, String address, String city, String stateprovince, String postalcode, String username, String password, String confirmpassword) {
        RP = new RegistrationPage(driver);
        RP.clickonregister();
        RP.Register(firstname, lastname, phonenumber, email, address, city, stateprovince, postalcode, username, password, confirmpassword);

        //SoftAssertion on UserName
        String UN = "Note: Your user name is "+username+".";
        SA.assertEquals(UN,RP.usernamenote(),"Incorrect UserName");
        SA.assertAll();
    }
}
