import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Log;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class BaseExtension {

    protected WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();


    public BaseExtension() {
        Log.classThreadInfo(BaseExtension.class);
    }

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Log.info("WebDriverManager initialized");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Log.info("WebDriver Selenium logLevel=0, ChromeDriverService=silent_output_mode");
    }

    @BeforeEach
    void setupDriver() {
        Log.info(chromeOptions.getBrowserName() + chromeOptions.getBrowserVersion());
        List<String> chromeArgs = Arrays.asList("--headless", "--disable-gpu",
                "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        chromeOptions.addArguments(chromeArgs);
        driver = new ChromeDriver(chromeOptions);
        Log.info("Drivers started with chromeOptions");
        Log.info("ChromeOptions Arguments: " + chromeArgs);
    }

    @AfterEach
    void teardown() {
        Log.info("Selenium Web driver shutdown attempt...");
        try {
            driver.quit();
            Log.seleniumThreadExitInfo();
        } catch (Exception e) {
            Log.warn("Selenium Web driver has not been closed!!! : " + e);
        }
    }
}
