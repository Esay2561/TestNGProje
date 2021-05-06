package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

      /*
   http://fhctrip-qa.com/admin/HotelAdmin/Create
1 - FhcTripHotelCreatePage ---- PAGES paketinde
	code, name, adress, phone, mail, idgroup, save bu webelementleri @FindBy
	kullanarak locate edelim.
2 - FhcTripHotelCreateTest ---- TESTS paketinde
	FhcTripHotelCreatePage class'ından nesne üretelim ve içerisindeki webelementleri kullanarak hotel oluşturalım.
	    public void giris(){
        	driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        	driver.findElement(By.id("UserName")).sendKeys("manager2");
        	driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ 	Keys.ENTER);
    */

    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ 	Keys.ENTER);
    }

    @Test(  groups = {"fhctrip", "hotelolusturma"} )
    public void aramaTesti(){
      giris();

        FhcTripHotelCreatePage fhcTripHotelCreatePage=new FhcTripHotelCreatePage(driver);
        fhcTripHotelCreatePage.code.sendKeys("1234");
        fhcTripHotelCreatePage.name.sendKeys("Semra");
        fhcTripHotelCreatePage.address.sendKeys("My Address....");
        fhcTripHotelCreatePage.phone.sendKeys("99999999");
        fhcTripHotelCreatePage.email.sendKeys("Semrabilgic@gmail.com");
        Select select = new Select(fhcTripHotelCreatePage.idgroup);
        select.selectByIndex(2);
        //fhcTripHotelCreatePage.submit.sendKeys(Keys.ENTER);
        fhcTripHotelCreatePage.submit.click();
    }
}
