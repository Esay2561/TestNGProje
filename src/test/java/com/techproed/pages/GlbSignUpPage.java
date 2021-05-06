package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy ( id = "email" )
    public WebElement emailBox;
    @FindBy ( id = "name")
    public WebElement nameBox;
    @FindBy ( id = "mobile" )
    public WebElement mobileBox;
    @FindBy ( id = "password")
    public WebElement passwordBox;

    @FindBy ( id = "re_password")
    public WebElement rePasswordBox;

    //button[@name='submit'][1]

    @FindBy ( xpath = "//button[@name='submit'][1]")
    public WebElement signUp;

    @FindBy(xpath = "//strong")
    public WebElement successText;

}