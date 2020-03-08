package tests;

import BasePackage.BaseTest;
import com.ahmed.excelizer.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTest extends BaseTest {
    public static SignInPage SIP;

    @DataProvider(name = "datareader")
    public Object[][] userdata() {
        return ExcelReader.loadTestData(System.getProperty("user.dir") +
                "\\Data\\SiliconExcel.xlsx", "SignInPage");
    }


    @Test(priority = 1)
    public void SigninClick() {
        SIP = new SignInPage(driver);
        SIP.clickonsignin();
    }

    @Test(dataProvider = "datareader", priority = 2)
    public void UserCanSignin(String username, String password) {
        SIP = new SignInPage(driver);
        SIP.Signin(username, password);
    }
}
