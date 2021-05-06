package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FaceBookLoginTest extends TestBase {

    @Test
    public void girisTesti(){
        driver.get("http://facebook.com");
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        loginPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("fb_email"));//emaili almak istedigimiz icin email yazdik
        loginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("fb_pass"));//sifreyi  almak istedigimiz icin fb_pass  yazdik

        /*
        configuration classi nicin olustiurdk
        proje ilk calistirildiginda  hafizada configurationreader olusturuluyor getproprty hazi  class adini yazinca dogrudan erisebiliyoruz
        dolayisiyle properties i kullaniyoruz .herhangi anahtari retun ediyor  emailse email  pass ise pass
        ConfigurationReader.getProperty("fb_pass"));manasi
        configirationa git  getproperty metodu bul icinde icinde paremetre3 olarak  mesela  fb_pass   gonder

         */


    }
}