package com.techproed.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public abstract class TestBaseFinal {
    protected WebDriver driver;
    //HERSEFERINDEALTTAKI 3UNUN OLUSTURNMAK ZORUNDAYIZ
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;//ustteki 3 adet degisken sabit olarak olusturulur .
    //bunlar kalip ekledigimiz kutuphanelerle alakali

    @BeforeTest(alwaysRun = true)//herzaman calistir.
    //before test test islemine baslamadan once calisir .rapor alama islemleri burada olusturulmus
    public void setUpTest() {//This is how to set up Extent report. We will create and use this one in out test classes / Kapsam raporu bu şekilde kurulur. Bunu test sınıflarında oluşturup kullanacağız
        extentReports = new ExtentReports();//1. create object to set the location of the report 1. raporun konumunu ayarlamak için nesne oluşturun
       //rapor olustuktansonra nereye eklemek eklensin
        String filePath = System.getProperty("user.dir") + "/test-output/myprojectreport.html";
        //olusturak istediginiz raporu test-output KLASORUUNDE  html formatinda baslatiyor  filepath iledosya yolunu belirliuiyoruz
        //daha sonra olusturlan raporu extendsreport un icine atiyoruz bunlar kalip
//testngde rapor almak icin aventstack kutuphanesinden yardim alarak html raporiumu olusturuyorum
//testng kendi raporunu kendi olusturmaz
        /*create a custom report in the current project.
        //Folder name = test-output, File name = report.html
        String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        / * mevcut projede özel bir rapor oluştur.
         // Klasör adı = test-output, Dosya adı = rapor.html
         String filePath = System.getProperty ("user.dir") + "\\ test-output \\ report.html"; // BU WINDOWS KULLANICISI İÇİN
         */
// istene bilgileri eklersiniz
        extentHtmlReporter = new ExtentHtmlReporter(filePath);//2. creating the report with the path we created
        extentReports.attachReporter(extentHtmlReporter);//3. attaching the html report to our custom report
        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
       //istediginiz bilgileri buraya ekleyebilirsiniz
        //setSystemInfo  ile istediginiz bilgileri eklersizi

        extentReports.setSystemInfo("Environment", "Environment Name");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));//chrome ise chrome farkli ise onu ekler
        extentReports.setSystemInfo("Automation Engineer", "ENGINEER INFORMATION");
        extentHtmlReporter.config().setDocumentTitle("Google Arama Testi");//rapora baslik ekliyoruz
        extentHtmlReporter.config().setReportName("Google Arama Automation Reports");
    }
    @AfterMethod(alwaysRun = true)//test basarisizca
    //In AfterMethod, we are getting the screenshots and attaching the report when test fails
    // AfterMethod'da, ekran görüntülerini alıyoruz ve test başarısız olduğunda raporu ekliyoruz
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {//When test case fails, then take the screenshot and attached the report
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
        Driver.closeDriver();
    }
    @AfterTest(alwaysRun = true)//ile raporu bitiriyorsunuz .
    public void tearDownTest() {
        extentReports.flush();
    }//ile raporu bitiriyoruz.
}