import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://www.saucedemo.com/";
    }

    @BeforeEach
    void beforeTesting() {
        if (hasWebDriverStarted()) {
            getWebDriver().manage().deleteAllCookies();
        }
        open("");
    }

    @AfterAll
    static void afterTesting() {
        getWebDriver().manage().deleteAllCookies();
    }
}
