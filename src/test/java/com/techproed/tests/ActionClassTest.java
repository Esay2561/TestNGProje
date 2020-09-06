package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends com.techproed.utilities.TestBase {

    @Test
    public void sagTiklama(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);


        actions.contextClick(element).perform(); // bir webelement'e sağ tıklamak için bu kodu kullanırız.
        // actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.
    }

    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);

        actions.doubleClick(button).perform(); // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
    }

    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        actions.moveToElement(menu).perform();   // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
    }

    @Test
    public void asagiYukari(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.PAGE_UP).perform();

    }


}