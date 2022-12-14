import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import utility.Log;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteTest extends BaseExtension {

    public SiteTest() {
        Log.classThreadDebug(SiteTest.class);
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"SII"})
    @DisplayName("Check the title of sii.pl")
    @Tag("regression")
    @Tag("booking")
    void checkTitleForSiiPl(Titles title) {
        Log.startTestCase(testInfo);
        driver.get("https://sii.pl/");
        Log.info("Driver get sii.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
        Log.endTestCase(testInfo);
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"ONET"})
    @DisplayName("Check the title of onet.pl")
    @Tag("regression")
    @Tag("onet")
    void checkTitleForOnetPl(Titles title) {
        Log.startTestCase(testInfo);
        driver.get("https://www.onet.pl");
        Log.info("Driver get onet.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
        Log.endTestCase(testInfo);
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"KOTUSZKOWO"})
    @DisplayName("Check the title of kotuszkowo.pl")
    @Tag("regression")
    @Tag("kotuszkowo")
    void checkTitleForKotuszkowoPl(Titles title) {
        Log.startTestCase(testInfo);
        driver.get("http://kotuszkowo.pl/");
        Log.info("Driver.get kotuszkowo.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
        Log.endTestCase(testInfo);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    @DisplayName("Check the title of filmweb.pl")
    @Tag("regression")
    @Tag("filmweb")
    void checkTitleForFilmwebPl(String title) {
        Log.startTestCase(testInfo);
        driver.get("https://www.filmweb.pl");
        Log.info("Driver.get filmweb.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title);
        Log.endTestCase(testInfo);
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"SELENIUM"})
    @DisplayName("Check the title of selenium.dev")
    @Tag("regression")
    @Tag("selenium")
    void checkTitleForSeleniumDev(Titles title) {
        Log.startTestCase(testInfo);
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        Log.info("Driver.get kotuszkowo.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
        Log.endTestCase(testInfo);
    }
}