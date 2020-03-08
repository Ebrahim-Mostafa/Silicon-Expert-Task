package pages;


import BasePackage.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseTest {

    public SignInPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "sign-in")
    WebElement signin;

    @FindBy(name = "userName")
    WebElement UserName;

    @FindBy(name = "password")
    WebElement Password;

    @FindBy(name = "login")
    WebElement submitbtn;

    public void clickonsignin(){
        signin.click();
    }

    public void Signin(String username, String password) {
        UserName.sendKeys(username);
        Password.sendKeys(password);
        submitbtn.click();
    }
}