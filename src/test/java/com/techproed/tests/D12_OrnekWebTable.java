package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class D12_OrnekWebTable extends TestBase {

    // 1. "http://fhctrip-qa.com/admin/HotelRoomAdmin" bu adrese gidiniz.
    // 2. Tbody'nin içerisinde kaç satır var, satır sayısını ekrana yazdırınız.
    //    tbody/tr -> findElements
    // 3. Üçüncü satırdaki verileri ekrana yazdırınız.
    //    tbody/tr[3]
/*
ONEMLI

//thead/tr/th       // Tüm başlıkları alabiliriz.
//tbody/tr/td     //tum tabloyu aldik
//tbody/tr                //Tablodaki hucreleri almak
//tbody/tr/td[4]  veya  //tbody//td[4]              //yalnizca bir sutunu alma
Mesela name  sutunu  tum verileri nasil alabiliriz
/ Slash  cocuguna   //slash torununa kadar gider
Xpathi kullanmayla alakali

Istedigimiz satir istedigimiz sutun bilgilerini alma
En cok kullanilacak metod
KALIP XPATH
"//tbody/tr["+satir+"]/td["+sutun+"]";
 //tbody/tr[3]/td[5]

 */
    @Test
    public void test(){
        giris();
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));//xpathin kullanimini iyi ogren
        System.out.println("Tabloda " + tumSatirlar.size() + " tane satır vardır.");//tum satirlar sayisi kadar tabloda satir var kod dinamik oldu
        WebElement ucuncuSatir = driver.findElement(By.xpath("//tbody/tr[3]"));//3.cu satiri aldik
        System.out.println(ucuncuSatir.getText());//3.satiri yazdurdik
    }
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }
}




