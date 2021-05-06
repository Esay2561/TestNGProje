package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D15_Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    //before metod yazdikki her testten once calissin  mesela siteye giris islemini yapsin tek senaryo oldugu icin before metod yazdik
    public void girisTest() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test//befor method yazmasaydik depend ile usttekine baglayabilirdik  @Test(dependOnMethod="girisTest")
    public void hotelCreate() {
        WebElement codeKutusu = driver.findElement(By.id("Code"));
        WebElement nameKutusu = driver.findElement(By.id("Name"));
        WebElement adresKutusu = driver.findElement(By.id("Address"));
        WebElement phoneKutusu = driver.findElement(By.id("Phone"));
        WebElement emailKutusu = driver.findElement(By.id("Email"));
        WebElement idGrup = driver.findElement(By.id("IDGroup"));
        WebElement saveButonu = driver.findElement(By.id("btnSubmit"));
// WebElement codeKutusu = driver.findElement(By.id("Code")).sendKeys("1234"); boyle uzunda yazilabilir.
        codeKutusu.sendKeys("1234");
        nameKutusu.sendKeys("Hamza Yılmaz");
        adresKutusu.sendKeys("Çıkmaz Sk. 34/20");
        phoneKutusu.sendKeys("022222222222");
        emailKutusu.sendKeys("merhaba@dunya.com");

        Select select = new Select(idGrup);//selcet nesnesi urettik drop down oldugu icin
        select.selectByIndex(2);    //dropDown oldugu icin select i kullanmaliyiz 2.ci siradakini tercih  ettik
        saveButonu.click();
        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));oncebunu yazdik sonrsaassert
        //ancak test failed oldu neden bekleme suresi koymadik sonraexplicitliy ait cin nesneurettikk  ve test passed oldu
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());

    }
}
