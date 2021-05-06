package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;

public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        // C:/Users/isimsiz/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";
        boolean varMi = exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
    }

    @Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu=driver.findElement(By.id("file-upload"));
        dosyaSecmeButonu.sendKeys("/Users/semrayerlikaya/Downloads/logo.png");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement uploadButonu=driver.findElement(By.id("file-submit"));
        uploadButonu.click();

        WebElement fileUploadYazisi=driver.findElement(By.tagName("h3"));
        //Assert.assertTrue(fileUploadYazisi.isDisplayed());

    }

    @Test
    public void dosyaDownload(){
        driver.get("http://the-internet.herokuapp.com/download");

                WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("/Users/semrayerlikaya/Downloads/Amsterdam.jpg"));
        Assert.assertTrue(varMi);

    }
}
