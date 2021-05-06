package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends com.techproed.utilities.TestBase {
//D7
    @Test
    public void sagTiklama() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        //webelementi bulduktan sonrqa action classtan nesne uretiebiliriz
        Actions actions = new Actions(driver);//paremetre driver

        actions.contextClick(element).perform(); // once web elenti bulduk sonra kod yazdik
        // bir webelement'e sağ tıklamak için bu kodu kullanırız.
        // actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.
    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);

        actions.doubleClick(button).perform(); // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.cifttiklamak istedigimizi web elementi yaziyoruz burada buttomdi
    }

    @Test
    public void hoverOver() {
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        actions.moveToElement(menu).perform();   // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
    }
        //klavye butonlari icin
    @Test
    public void asagiYukari() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();//asagi gittik

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.END).perform();//pagedown yeterli olmadigi icin end yazdik

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.PAGE_UP).perform();//ustte gitmek icin

    }

    @Test
    public void buyukKucukYazma() {

        // MERHABA nasılsınız//SHIFTE BASILI TUTARAK YAZARSANIZ BUYUK YAZAR BIRAKIRSANIZ KUCUKYAZAR

        driver.get("http://google.com");
        // name="q"
        WebElement aramaKutusu = driver.findElement(By.name("q"));

        // bu standart yazma methodumuz
        //aramaKutusu.sendKeys("merhaba nasılsınız");

        // bu şekilde her karakteri büyük yapar
        // aramaKutusu.sendKeys(Keys.SHIFT + "merhaba nasılsınız");
// SHIFTE BASILI TUTARAK BUYUK HARFLE YAZDIRIYORUZ
        Actions actions = new Actions(driver);//action class nesnesi urettik ki butonlara tiklayalim
        actions.moveToElement(aramaKutusu).click()//mousu web elementin uzerune goturur biz dedikki aramakutusuna
                //git ve tikla
                .keyDown(Keys.SHIFT)//Keys.SHIFT demek  shifte basili tutuyor
                .sendKeys("merhaba")
                .keyUp(Keys.SHIFT)//shifftten kaldiriyor elini kaldir demek
                .sendKeys(" nasılsınız")
                .perform();//mutlaka yazilmali

    }

    @Test
    public void dragAndDrop() {  // sürükle - bırak
        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        WebElement logo = driver.findElement(By.id("hplogo"));

        Actions actions = new Actions(driver);
        // logo webelementini, aramaKutusu webelementine sürükle ve bırak.
        actions.dragAndDrop(logo, aramaKutusu).perform();//parentez icine tasimakistedigin elementi ve nereye tasiyacagini
        //yazmalisin    target    hedef


    }
}
