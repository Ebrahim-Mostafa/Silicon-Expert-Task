package BasePackage;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static ATUTestRecorder recorder;

    @BeforeTest
    public void SetUp() throws ATUTestRecorderException {
        String location = System.getProperty("user.dir") + "\\Data\\";
        recorder = new ATUTestRecorder(location, "Silicon-Expert-Run", false);
        recorder.start();
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");
        //option.addArguments("--start-fullscreen");
        option.addArguments("--start-maximized");
        option.setHeadless(false);
        //option.addArguments("--headless");
        driver = new ChromeDriver(option);
        driver.get("http://newtours.demoaut.com/mercuryreservation.php");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
    }

    @AfterTest
    public void TearDown() throws ATUTestRecorderException {
        driver.quit();
        recorder.stop();
    }
}
