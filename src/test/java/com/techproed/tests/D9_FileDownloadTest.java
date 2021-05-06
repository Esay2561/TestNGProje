package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;

public class D9_FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));//bulundugumuz sayfanin adresini verdi
        System.out.println(System.getProperty("user.home"));//kullanici klasorunu yani anaklasorunu verdi
        //bilgisayar bilgisayardavar mi dosyayolu test NG deki pom.xml li varmi diye kontrol ediyoruz
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        // C:/Users/isimsiz/IdeaProjects/TestNGProje/pom.xml//bilgisayardaki dosyayolu
        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";
        boolean varMi = exists(Paths.get(pomXmlDosyaYolu));//Files.exists(Paths.get(DosyaYolu));
        System.out.println(varMi);//dosyavarsatrue  yoksa false
       //Files.exists(Paths.get(DosyaYolu));  KALIP IFADEDIR  EZBERLEMELI   JAVA ILE ALAKALIDIR .
       //  Assert.assertTrue(varMi);
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
        boolean varMi = exists(Paths.get("/Users/semrayerlikaya/Downloads/Amsterdam.jpg"));
        Assert.assertTrue(varMi);

        //D1O WAIT TEST

    }
}




