package pages;


import BasePackage.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends BaseTest {

    public FlightFinderPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(name="fromPort")
    WebElement DepartingFrom;

    @FindBy(name = "toPort")
    WebElement ArrivingIn;

    @FindBy(name = "airline")
    WebElement Airline;

    @FindBy(name = "findFlights")
    WebElement Continue_btn;

    @FindBy(xpath = "//input[@value='Pangea Airlines$362$274$9:17']")
    WebElement Depart;

    @FindBy(xpath ="//input[@value='Pangea Airlines$632$282$16:37']" )
    WebElement Return;

    @FindBy(name = "reserveFlights")
    WebElement Reservebtn;

    @FindBy(name = "buyFlights")
    WebElement Purchase;

    @FindBy(xpath = "//img[@src='/images/masts/mast_confirmation.gif']")
    WebElement FlightConfirm;

//    @FindBy(xpath = "//*[contains(text(),'Your itinerary has been booked!')]")
//    WebElement confirmTxt;

    @FindBy(xpath = "//*[contains(text(),'Zurich to Paris')]")
    WebElement Departing;

    @FindBy(xpath = "//*[contains(text(),'Paris to Zurich')]")
    WebElement Returning;

    public void BookFlight() {

        Select from = new Select(DepartingFrom);
        from.selectByValue("Zurich");
        Select to = new Select(ArrivingIn);
        to.selectByValue("Paris");
        Select airline = new Select(Airline);
        airline.selectByVisibleText("Pangea Airlines");
        Continue_btn.click();
        Depart.click();
        Return.click();
        Reservebtn.click();
        // ScrollIntoWebElement
        JavascriptExecutor js = ((JavascriptExecutor) BaseTest.driver);
        js.executeScript("arguments[0].scrollIntoView();", Purchase);
        Purchase.click();
    }

    public boolean hasbeenbooked(){
        boolean book = FlightConfirm.isDisplayed();
        return book;
    }

//    public String confirmatioText(){
//        String confirm=confirmTxt.getText();
//        return confirm;
//    }

    public String depart(){
        String Depart = Departing.getText();
        return Depart;
    }
    public String returning(){
        String returnn = Returning.getText();
        return returnn;
    }
}