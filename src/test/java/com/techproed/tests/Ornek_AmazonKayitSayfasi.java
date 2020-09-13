package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase  {    // DAY 14 - 6 Eylül 2020 Pazar
    // 4 dk süreniz.
    // 1. Adım : Mouse'u moveToElement methodunu kullanarak, Account & Lists
    //           webelementinin üzerine götürün.
    // 2. Adım : Start here. linkine tıklayın.
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);//mouse ve klayve yi kulanmak icin mutlaka actions objesi uretilmeli
        WebElement button = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(button).perform();    // mouse'u webelement'in üzerine götürme işlemi yapıyoruz.
        // xpath ->      //*[.='Start here.']
        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
        startHereLink.click();
        // 3. Adım : Sayfanın title'ı Amazon Registration ise testiniz başarılı olsun.
        // True kullanarak Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
        // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(),"Amazon Registration");

    }

        @Test (dependsOnMethods = "test01")
        public void test02() {
            WebElement isim = driver.findElement(By.id("ap_customer_name"));
            isim.sendKeys("Hamza Yılmaz");
            //alta yazilanlarda WebElement button = driver.findElement(By.id..yazilmadi boylede olabilir problem olmaz
            //parentez sonrasi. konursa sendKeys le icine gonderilebilir .
            driver.findElement(By.id("ap_email")).sendKeys("hamzayilmaz2020@protonmail.com");
            driver.findElement(By.id("ap_password")).sendKeys("Amazon06.");
            driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06.");
            driver.findElement(By.id("continue")).click();

        }



}


