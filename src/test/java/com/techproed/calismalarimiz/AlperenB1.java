package com.techproed.calismalarimiz;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;
/*
Bugünkü ödevimiz:
1)Amazon.com a gidin
2)sol üstte menü seçeneği var ona tıklayın (3 çizgi şeklinde)
3) oradan "Software" I seçin
4) sonra "Programming & Web Development" i seçin
5) açılan yeni sayfada sol alt kısımda "Price" yeri var. Orada min ve max kutucuklarına 10 ve 20 yazın.
6) kutuları doldurduktan sonra hemen yanındaki "Go" butonuna tıklayın.
7) son olarak da açılan sayfanın URL ini alıp ekrana yazdıralım
 */
public class AlperenB1 extends TestBase {

    @Test
    public void test1() {
        driver.get("http://amazon.com");
        //menu web elemani dropDown
        WebElement dropDown = driver.findElement(By.id("nav-hamburger-menu"));
        dropDown.click();//menu ye tikla
        //menu deki "software" kismi
        WebElement software = driver.findElement(By.xpath("//a[@data-menu-id='22']"));
       //bunun id si, name i falan yoktu. o yuzden xpath le boyle bulabildim
        software.click();//"software" secenegine tikla
        //"software" icindeki "programming..." kismi
         WebElement programmingLink = driver.findElement(By.partialLinkText("Programming"));
       //bu bir  link olarak kod lanmis, o yuzden partialLinkText() iyidir
        programmingLink.click();//tikla
       //yeni sayfa acildi su an
       //minimum price kutusu
        WebElement minBox = driver.findElement(By.id("low-price"));
        minBox.sendKeys("10");//10 sayisini yazdirmak icin
       //maximum price kutusu
        WebElement maxBox = driver.findElement(By.id("high-price"));
        maxBox.sendKeys("20");//20 sayisini yazdirmak icin
        //"Go" butonunu bulup tiklamak yerine direkt .submit() yapsak da olur
       //bu bize kalmis
        maxBox.submit();//submit() >> enter tusuna basmak gibi
       //bu da bulundugumuz sayfanin URL i
        System.out.println(driver.getCurrentUrl());

    }
}