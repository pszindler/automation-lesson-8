import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;

abstract class BaseExtension {

    static protected WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @BeforeEach
    void setupDriver() {
        chromeOptions.addArguments("--headless", "--disable-gpu",
                "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
