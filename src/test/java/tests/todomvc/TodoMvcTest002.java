package tests.todomvc;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import tests.todomvc.page.TodoMvcPage;

public class TodoMvcTest002 {
    private static final String SELENIUM_SERVER_URL = "http://192.168.99.100:4444";
    private static final String APP_URL = "http://todomvc.com/examples/angularjs";

    @BeforeClass
    public static void setUpClass() {
        Configuration.remote = SELENIUM_SERVER_URL + "/wd/hub";
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @After
    public void teardown() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((RemoteWebDriver) driver).executeScript("localStorage.clear();");
        refresh();
    }

    @Test
    public void test001() throws InterruptedException {
        TodoMvcPage page = open(APP_URL, TodoMvcPage.class);
        page = page.addTask("1234567890");
        assertThat(page.getViewLabelTexts(), is(contains("1234567890")));
    }

    @Test
    public void test002() throws InterruptedException {
        TodoMvcPage page = open(APP_URL, TodoMvcPage.class);
        page = page.addTask("a");
        page = page.addTask("b");
        page = page.addTask("c");
        page = page.addTask("d");
        assertThat(page.getViewLabelTexts(), is(contains("a", "b", "c", "d")));
    }
}
