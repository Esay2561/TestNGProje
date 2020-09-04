package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DenemeIF {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void denemeif() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);    //asagida index ile Iframe gecis yapildi
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();//IFrame icindeki yaziyi siler seninkini yazdirir
        paragraf.sendKeys("Merhaba Iframe");

    }

    @Test
    public void denemeif1() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");// id attributeu kullanılarakta iframe'e geçiş yapabiliriz.
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");


    }

    @Test
    public void denemeif2() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);



    }


}
