package com.techproed.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FhcTripHotelRoomCreatePage {

    /*
      Bulmamız gereken webelementler.
IDHotel, Code, Name, Location, Description, Price, 500, Room type,
Max Adult count, Max Children count, Approved, Save
1. Adım : Tüm webelementleri "pages" paketinin altında oluşturacağımız, FhcTripHotelRoomCreatePage class'ının içerisinde @FindBy şeklinde bulalım.
2. Adım : smoketests -> FhcTripHotelRoolCreateTest class oluşturalım.
3. Adım : FhcTripHotelRoolCreateTest class'ının içerisinde @Test methodu oluşturacağız.
4. Adım : driver.get(ConfigurationReader.getProperty("room_create_url")) ile HotelRoomCreate sayfasına gidelim.
5. Adım : FhcTripHotelRoomCreatePage class'ından nesne oluşturalım ve içerisindeki webelementleri kullanalım.
6. Adım : WebElementlerin içerisini dolduralım.
room_create_url = http://fhctrip-qa.com/admin/HotelroomAdmin/Create
dropdown kismini normaldefind by ile bulacagiz sonratest clasinda select nesnesiyazmamizlazim pagesta sadece locateedecegiz
*/


    WebDriver driver;
    public FhcTripHotelRoomCreatePage(WebDriver driver){
        this.driver = driver;
        // paremetre olarak ZORUNLU olarak driver nesnemizi, this kelimeisni yazmamız lazım
        PageFactory.initElements(driver, this);
    }
    @FindBy ( id = "IDHotel" )
    public WebElement idHotelDropDown;
    @FindBy ( id = "Code")
    public WebElement codeKutusu;
    @FindBy ( id = "Name" )
    public WebElement nameKutusu;
    @FindBy ( id = "Location")
    public WebElement locationKutusu;
    @FindBy ( xpath = "//textarea[@dir='ltr']")
    public WebElement descKutusu;
    @FindBy ( id = "Price")
    public WebElement priceKutusu;
    @FindBy ( partialLinkText = "500" )
    public WebElement price500;
    @FindBy ( id = "IDGroupRoomType")
    public WebElement idGroupRoomTypeDropDown;
    @FindBy ( id = "MaxAdultCount" )
    public WebElement maxAdultCountKutusu;
    @FindBy ( id = "MaxChildCount" )
    public WebElement maxChildCountKutusu;
    @FindBy ( id = "IsAvailable" )
    public WebElement approved;
    @FindBy ( id = "btnSubmit" )
    public WebElement saveButonu;
    @FindBy ( xpath = "//*[.='HotelRoom was inserted successfully']")
    public WebElement basariliYazisi;
}