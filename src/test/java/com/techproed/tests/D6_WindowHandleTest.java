package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class D6_WindowHandleTest extends TestBase {
//TestBase extendsettik ki before after class anotations larini tekrar etmeyelim .
    //kod kalabaligindankurtulmakicin
    @Test
    public void cokluPencereTest(){

        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();//SAYFANIN BENZRSIZ UNIGUE ID SINI ALIRSINIZ.ALDIGIMIZ HANDLE
        //SU HANDLE GEC DIYECEGIZ.

        System.out.println(sayfaninHandle);
      //String sayfaHandle =driver.driver.findElement(By.partialLinkText("Click Here")).
        //sayfaHandle.click();   yerine sadece asagidakinide yazsak olurilla degisken olusturmaya gerek yok

        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> tumPenceler = driver.getWindowHandles();//FOR EACH ILEALIR EKRANA YAZDIRILIR
         /*
         elinizdeki tüm pencerelerin windows handle'larını bu şekilde ekrana yazdırabilirsiniz.
         for(String handle : tumPenceler){
             System.out.println(handle);
         }*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object[] array = (Object[]) tumPenceler.toArray();//TO ARRAYILEARRAYE CEVIRDIK  YA ITARATOR YA ARRAYE CEVRIP
        String ikinciSayfaHandle = array[array.length - 1].toString();//ARRAY SON ELEMANINI ALMAK ICIN
        System.out.println(ikinciSayfaHandle);
        driver.switchTo().window(sayfaninHandle);

        //NOT D7_ACTION CLASS

    }

}