package pages;


import BasePackage.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {

    public RegistrationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='REGISTER']")
    WebElement register;

    @FindBy(name = "firstName")
    WebElement FirstName;

    @FindBy(name = "lastName")
    WebElement LastName;

    @FindBy(name = "phone")
    WebElement PhoneNumber;

    @FindBy(id = "userName")
    WebElement Email;

    @FindBy(name = "address1")
    WebElement Address;

    @FindBy(name = "city")
    WebElement City;

    @FindBy(name = "state")
    WebElement State_Province;

    @FindBy(name = "postalCode")
    WebElement PostalCode;

    @FindBy(name = "country")
    WebElement Country;

    @FindBy(id = "email")
    WebElement User_Name;

    @FindBy(name = "password")
    WebElement Password;

    @FindBy(name = "confirmPassword")
    WebElement ConfirmPassword;

    @FindBy(name = "register")
    WebElement Submit_btn;

    @FindBy(xpath = "//*[contains(text(),'Note: Your user name is')]")
    WebElement Note;

    public void clickonregister() {
        register.click();
    }

    public void Register(String firstname, String lastname, String phonenumber, String email, String address, String city, String stateprovince, String postalcode, String username, String password, String confirmpassword) {
        FirstName.sendKeys(firstname);
        LastName.sendKeys(lastname);
        PhoneNumber.sendKeys(phonenumber);
        Email.sendKeys(email);
        Address.sendKeys(address);
        City.sendKeys(city);
        State_Province.sendKeys(stateprovince);
        PostalCode.sendKeys(postalcode);
        Select country = new Select(Country);
        country.selectByValue("56");
        User_Name.sendKeys(username);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(confirmpassword);
        // ScrollIntoWebElement
        JavascriptExecutor js = ((JavascriptExecutor) BaseTest.driver);
        js.executeScript("arguments[0].scrollIntoView();", Submit_btn);
        Submit_btn.submit();
    }

    public String usernamenote(){
        String note = Note.getText();
        return note;
    }
}