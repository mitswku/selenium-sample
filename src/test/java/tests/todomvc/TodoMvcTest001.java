package tests.todomvc;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class TodoMvcTest001 {
    @BeforeClass
    public static void setUpClass() {
        Configuration.remote = "http://192.168.99.100:4444/wd/hub";
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void test001() throws InterruptedException {
        open("http://todomvc.com/examples/angularjs");
        $("#new-todo").val("1234567890").pressEnter();

        String[] texts = $$(".view label").getTexts();
        assertThat(texts, is(arrayContaining("1234567890")));
    }
}
