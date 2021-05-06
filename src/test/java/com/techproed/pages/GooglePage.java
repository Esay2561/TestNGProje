package com.techproed.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class GooglePage {//IHTIYAC DUYULAN WEB ELEMENTLERI SAKLADIGIMIZ CLASS  ONCE CONSTRUCTOR OLUSTURYORUZ
    // boş bir tane driver değişkeni oluşturduk.
    WebDriver driver;//INSTANCE VARIABLE
    public GooglePage(WebDriver driver){//BU CONSTRACTOR  NASIL ANLADIK CLASSLAAYNI ISIM VE RETUNT TYPE YOK
        //CONSTRUCTORIN 1 TANE PAREMETRESI OLUR (WebDriver driver)
        //NORMALDE  WebDriver driver =newChromeDriver();yaziyorduk nesne olusturuyordum ama istiyoruzki paremetreolarak yazdigimiz driveri
        //alsin yani dinamik olsun yeniden nesne olusturmak istemedik bir nevi miras aldik


      /*
        HER PAGE CLASSINDASABIT OLACAK KOD  EZBERLEMELISIN
       WebDriver driver;             //INSTANCE VARIABLE
       public GooglePage(WebDriver driver){
       this.driver = driver;   10.SATIRDAKI DRIVER PAREMETRE OLARAK GELEN DRIVERE ESITLEDIK
       SONRA KALIP
       PageFactory.initElements(driver,this); YAZIYORUZ BU KODLA BULACAGIMIZ WEB ELEMENTLERI HAZR HHALE GETIRIYORUZ

       */


        // parametre olarak gelen driver nesnesini, bu class'ta oluşturduğumuz
        // (9. satırdaki) driver nesnesine eşitledik. Bu şekilde yeniden boş bir
        // driver oluşturmak yerine, zaten halihazırda kullandığımız driver'ı bu nesneye
        // eşitlemiş olduk.
        this.driver = driver;
        // birazdan bulacağımız webelementleri hazır hale getirdik.
        PageFactory.initElements(driver,this);//BU BINANAI TEMELI GIBI ELEMENT ARIYORSANIZ YAZMANIZ SART
    }
    @FindBy ( name = "q" )//normalde driver.findElements(By.xpath(""));yazarak kbuluyorduk ancal
    //pageste findElement yerine     @FindBy ( name = "q" ) kullanacagiz
    public WebElement aramaKutusu;  // findElement

    //bu sekilde istediginiz kadar  @FindBy ( xpath = "//tbody/tr") yazabilirsiniz
    /*
    listseklinde almakistersenizde
    @FindBy ( xpath = "//tbody/tr")
    public List<WebElement> liste;  // findElements (s harfine dikkat)
    PAGES PCLASI OLUSTURP KULLANMAK   BASIT VE KULLANISLIDIR .

    */
}