package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {  //oopi konsepti bize zaman kazandirir kod kalabaligindankurtarir
    WebDriver driver;
    public FacebookLoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);////her zaman yazilmali
    }
    @FindBy( id = "email" )
    public WebElement emailKutusu;

    @FindBy( id = "pass" )
    public WebElement sifreKutusu;

}
