package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

      /*
1)Amazon.com a git
2)Searchbox in hemen yanında bir drop down var ona tıkla. (burada Select kullanmalı)
3)Icinden "Books" u seç.
4)Arama kutusuna (search box) "orhan pamuk beyaz kale" yaz
5)Aramayı yap
---Buradan sonrası optional, isteyen devam edebilir---
6)ilk çıkan kitap seçeneğine tıkla
7)Girilen sayfanin title ını al
8)Title da "Beyaz" kelimesi geçiyor mu diye Assert le kontrol et.
Eger şu iki günün pratikleri fazla uzunsa/zorsa/kolaysa/karmaşıksa yazın. Ona göre değiştiririz.
 */

public class AlperenB2 extends TestBase {

    @Test
    public void test1 (){
      driver.get("https://www.amazon.com");  //AMAZONA GIT
        WebElement dropDown=driver.findElement(By.name("url"));
        dropDown.click();
        Select select = new Select(dropDown);//dropdown olunca mutlaka obje uretmeliyiz
        WebElement books=driver.findElement(By.id("searchDropdownBox"));
        books.click();
        WebElement search =driver.findElement(By.id("twotabsearchtextbox"));
        search.click();
       search.sendKeys("orhan pamuk beyaz kale");
        search.submit();
       WebElement ilkKitap=driver.findElement(By.className("s-image"));
       ilkKitap.click();
       WebElement SayfaBasligi=driver.findElement(By.className("a-size-extra-large"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Beyaz"));
       softAssert.assertAll();

    }


}
