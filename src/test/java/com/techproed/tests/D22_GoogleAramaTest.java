package com.techproed.tests;
import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
// TestBaseFinal class'ını miras alıyoruz çünkü TestBaseFinal class'ının içerisinde
// rapor almak için kullanacağımız nesneler ve methodlar var.
public class D22_GoogleAramaTest extends TestBaseFinal {
    //TESTNG DE NASIL RAPOR ALIYORUZ TESTI
    //TESTBASEFINALI MIRAS ALDIK CUNKU ICINDE KULLANACAGIMIZ METODLAR VAR
    //ARTIK TESTBASE CLASSI KULLANMIYORUZ  ZATEN BIRTANE EXTENDS YAPABILIRSINIZ
    // 1. Adım : Google.com'a gidelim.
    // 2. Adım : techproeducation araması yapalım
    // 3. Adım : sonuçlar içerisinde techproeducation.com var mı, doğrulayalım.
    /*
    classin ilk hali
     public void aramaTesti() throws InterruptedException {
     Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
      GoogleAramaPage googleAramaPage = new GoogleAramaPage();
      googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);
      Thread.sleep(3000);
       boolean linkVarMi = false;
        for(WebElement w : googleAramaPage.tumLinkler){
            if(w.getText().contains("techproeducation.com")){//eger techproeducation.com  varsa true dondur
                linkVarMi = true;
                break;
            }
            }

        Assert.assertTrue(linkVarMi);//dogrulama yapiyoruz

    NOT DRIVERI DINAMIK YAPTIGIMIZ ICIN CONSTRUCTOR ICINE PAREMETRE GONDERMEYE GEREK YOU

     */


    @Test
    public void aramaTesti() throws InterruptedException {
       //NASIL RAPOR ALINIR HERTESTIN ICINE ASAGIDAKI KOD YAZILMALI
        extentTest  = extentReports.createTest("Google Arama","Google'da techproeducation araması yaptık.");
        //BIRINCI BOLUM TESTIN ISMI IKINCI BOLUM TESTIN ACIKLAMASI
        //kaliplari iyi ogren nerde ne kullanilir .
        //SONRA HER ADIMI ADIM ADIM YAZIYORSUNUZ
        extentTest.info("sayfa adresine git.");//HER TURLU BILGIYI EKLIYORUZ ...
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
        extentTest.info("webelementleri kullanabilmek için nesne oluştur.");//tumyapacagin islemlerden once bilgi veriyoruz
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();
        extentTest.info("techproeducation araması yap.");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);
        extentTest.info("3 saniye bekle.");
        Thread.sleep(3000);
        extentTest.info("tüm linkleri karşılaştır.");
        boolean linkVarMi = false;//techproeducation.com  goremezse hep false kalacak varsa true
        for(WebElement w : googleAramaPage.tumLinkler){
            if(w.getText().contains("techproeducation.com")){//eger techproeducation.com  varsa true dondur
                linkVarMi = true;
                break;
            }
        }
        extentTest.info("assert işlemi yap.");
        Assert.assertTrue(linkVarMi);//dogrulama yapiyoruz
        extentTest.info("Testimiz PASSED !");//extentTest.pass yazarsanizyesil  ile gosterir assert ile yapmisssin pass olmus

    }
}