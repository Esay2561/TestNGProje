package com.techproed.utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    // ConfigurationReader class'ını projemizin heryerinden
    // nesne üretmeden, miras almadan kullanabilecek şekilde tasarlayalım.
    // static : program çalışır çalışmaz, bellekte yer tutmaya yarayan keyword

    static Properties properties;
    static{
        // okumak istediğimiz configuration.properties file'ın dosya yolu
        // C:\Users\isimsiz\IdeaProjects\TestNGProje\configuration.properties
        String path = "configuration.properties";
        // dene - hata varsa yakala.
        // bu işlemi DENE eğer hata alırsan, PROGRAMI DURDURMA
        try{
            // okumak istediğiniz dosyanın path(adres)'ini yazıyorsun
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            // fileInputStream'dan ürettiğim file dosyası burada, bunu kullanabilirsin
            properties.load(file);
        }catch (Exception e){
        }
    }
    //  properties.getProperty("username")  --> manager2
    //static bir metod yazacagiz   neden static nesne uretmeyecegiz dogrudan erisim istiyoruz
    //dosyada okuyacagimizdegerler string oldugu icin veri tipine  String yazdik isminede anlasilir olsun diye getproperty dedik
    // ve properties icindeki verileri okuyalim
    public static String getProperty(String key){//paremetre seklinde aldik her zaman String olur unutma
        //okumak icin properties.getProperty(key);icine paremetre olarak okumak istediginiz keyin anahtarini mesela username
        return properties.getProperty(key);//bu sekilde yazdik cunki diger classlardakullanacagiz
//bu kalipla projemizin her yerinden ulasabiliriz .
    }


}