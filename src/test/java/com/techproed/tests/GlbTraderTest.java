package com.techproed.tests;

import com.techproed.pages.GlbTraderPage;
import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {
      @Test
    public void aramaTesti() throws InterruptedException{
        extentTest  = extentReports.createTest("GlbTrader Arama","GlbTrader da camera araması yaptık.");
        extentTest.info("sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_search"));

        extentTest.info("webelementleri kullanabilmek için nesne oluştur.");
        GlbTraderPage glbTraderPage = new GlbTraderPage();

        extentTest.info("categori sec");
        Select select=new Select(glbTraderPage.kategorilerDropDown);
        select.selectByIndex(6);

        extentTest.info("camera araması yap.");
        glbTraderPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("glb_kelime")+Keys.ENTER);

          extentTest.info("2. sıradaki ürünün ismini aldık.");
          String urunIsmi= glbTraderPage.sonuclarListe.get(1).getText();

          extentTest.info("2. sıradaki ürüne tıkladık.");
          glbTraderPage.sonuclarListe.get(1).click();

          extentTest.info("3 saniye bekle");
          Thread.sleep(3000);

          extentTest.info("Sayfa başlığını aldık.");
          String sayfaBasligi = Driver.getDriver().getTitle();

          extentTest.info("Assert işlemi yapalım.");
          Assert.assertEquals(urunIsmi , sayfaBasligi);
          extentTest.pass("Testimiz PASSED !");





    }


}
