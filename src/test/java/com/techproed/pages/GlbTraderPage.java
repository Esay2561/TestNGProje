package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraderPage {
/*
DRIVER CLASSINDAN ONCE SOYLE YAZIYORDUK
WebDriver driver;
    public FacebookLoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);////her zaman yazilmali


 */
    public GlbTraderPage() {//constructor olusturmaamacimiz PageFactory.initElements i kullanmak
        PageFactory.initElements(Driver.getDriver(), this);//Driverolusturunca  teksaqtiradustu  classindan get driveri cagirdik
    }

    @FindBy(id = "type head']")
    public WebElement aramaKutusu;

    @FindBy(id = "header_search_category")
    public WebElement kategorilerDropDown;

    @FindBy(xpath = "//h4/a")
    public List<WebElement> sonuclarListe;


}
