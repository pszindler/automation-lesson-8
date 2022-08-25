import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteTest extends BaseExtension {

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"SII"})
    @DisplayName("Check the title of sii.pl")
    @Tag("regression")
    @Tag("booking")
    void checkTitleForBookingCom(Titles title) {
        driver.get("https://sii.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"ONET"})
    @DisplayName("Check the title of onet.pl")
    @Tag("regression")
    @Tag("onet")
    void checkTitleForOnetPl(Titles title) {
        driver.get("https://www.onet.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"KOTUSZKOWO"})
    @DisplayName("Check the title of kotuszkowo.pl")
    @Tag("regression")
    @Tag("kotuszkowo")
    void checkTitleForKotuszkowoPl(Titles title) {
        driver.get("http://kotuszkowo.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    @DisplayName("Check the title of filmweb.pl")
    @Tag("regression")
    @Tag("filmweb")
    void checkTitleForFilmwebPl(String title) {
        driver.get("https://www.filmweb.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title);
    }

    @ParameterizedTest
    @EnumSource(value = Titles.class, names = {"SELENIUM"})
    @DisplayName("Check the title of selenium.dev")
    @Tag("regression")
    @Tag("selenium")
    void checkTitleForSeleniumDev(Titles title) {
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.getTitle());
    }
}