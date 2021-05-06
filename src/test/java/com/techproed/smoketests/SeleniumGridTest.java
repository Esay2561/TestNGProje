package com.techproed.smoketests;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class SeleniumGridTest {
    @Test
    public void test() throws MalformedURLException {
        //1 ) Desired Capabilities tanımlama
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        //2 ) Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        //3 ) Hub adresimizi girelim
        String hubUrl = "http://192.168.2.12:8090/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);

        driver.get("http://www.amazon.com");
        System.out.println(driver.getTitle());
        driver.quit();



    }
}