package tests.google;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class GoogleSearchTest002 {

    @BeforeClass
    public static void setUpClass() {
        Configuration.remote = "http://192.168.99.100:4444/wd/hub";
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void test001() throws InterruptedException {
        open("http://www.google.com");
        $("#lst-ib").setValue("google");
        $("button[name=btnG]").click();

        Thread.sleep(20000);
        $(By.name("q")).shouldBe(Condition.name("fanme"));
    }
}
