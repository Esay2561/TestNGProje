package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GlbSignUpTest{
    /*
     * 1. Adım : https://www.glbtrader.com/register-verified.html adresine gidelim
     * 2. Adım : GlbSignUpPage class'ından nesne üretip, webelementleri kullanalım.
     * 3. Adım : İçerisine ekleyeceğimiz bilgileri (name, email, phone vs) yine
     *           ConfigurationReader kullanarak, properties file'dan alalım.
     * 4. Adım : Sign-Up butonuna tıklayalım.
     * 5. Adım : Success yazısını görüp görmediğimi Assert ile doğrulayalım.
     *
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite calisti");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest calisti");
    }
    @Test (  groups = {"glbtrader", "signup"} )
    public void test()
    {
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_login"));
        GlbSignUpPage page = new GlbSignUpPage( );
        page.emailBox.sendKeys(ConfigurationReader.getProperty("glb_email"));
        page.nameBox.sendKeys(ConfigurationReader.getProperty("glb_name"));
        page.mobileBox.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        page.passwordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        page.rePasswordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        page.signUp.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(page.successText.isDisplayed());
        System.out.println(page.successText.getText());
    }


}