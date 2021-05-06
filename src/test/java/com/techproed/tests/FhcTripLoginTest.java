package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
        /*1 - FhcTripLoginPage  ----- PAGES paketinin altında
	- 3 tane webelement bulmanız lazım.
		username, password, login
  2 - FhcTripLoginTest  ----- TESTS paketinin altında
	- @Test oluşturup.
	  FhcTripLoginPage class'ından nesne üretip, webelementleri kullanmanız lazım.*/

    @Test (  groups = {"fhctrip", "login"} )
    public void aramaTesti(){
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLoginPage fhcTripLoginPage=new FhcTripLoginPage(driver);
        fhcTripLoginPage.username.sendKeys("manager2");
        fhcTripLoginPage.password.sendKeys("Man1ager2!");
        fhcTripLoginPage.loginButton.sendKeys(Keys.ENTER);//fhcTripLoginPage.loginButton.click();

    }
}
