package tests.google;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearchTest001 {

    @Test
    public void test000() throws MalformedURLException, InterruptedException {
        URL remoteAddress = new URL("http://192.168.99.100:4444/wd/hub");
        Capabilities desiredCapabilities = DesiredCapabilities.chrome();

        RemoteWebDriver driver = new RemoteWebDriver(remoteAddress, desiredCapabilities);
        driver.navigate().to("https://www.google.com");

        Thread.sleep(20000);

        driver.quit();
    }
}
