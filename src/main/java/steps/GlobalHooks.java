package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tools.TakeScreenshot;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class GlobalHooks {
    private static ChromeDriver driver = null;

    public static ChromeDriver getDriverInstance(){
        return driver;
    }

    @Before()
    public void configuration() {
        try {
            new BackendSteps().addNewUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration.baseUrl = TestConfig.getConfig().getBase().getUrl();
        Configuration.browser = TestConfig.getConfig().getBrowser();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/main/java/util/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }


    @After()
    public void stopDriver() {
        try {
            TakeScreenshot.takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeWebDriver(); }
}