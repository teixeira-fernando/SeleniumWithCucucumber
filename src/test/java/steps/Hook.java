package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hook extends BaseUtil{


    private BaseUtil base;
    private String chosenBrowser = "Chrome";

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {


        if (this.chosenBrowser == "Firefox") {
            System.out.println("Opening the browser : " + this.chosenBrowser);

        /*System.setProperty("webdriver.firefox.marionette", "D:\\Libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/
        }
        else if (this.chosenBrowser == "Chrome") {

            //Chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            //options.addArguments("--disable-gpu");
            //    options.addArguments("--no-sandbox");
            //   options.addArguments("--disable-dev-shm-usage");
            // options.setExperimentalOption("useAutomationExtension", false);
            base.Driver = new ChromeDriver(options);
        }
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        base.Driver.quit();
        System.out.println("Closing the browser : "+this.chosenBrowser);
    }

}
