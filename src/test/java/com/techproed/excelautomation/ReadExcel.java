package com.techproed.excelautomation;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
public class ReadExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = ".\\src/test/resources/ulkeler .xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // 1. sayfaya gider. (index değeri 0'dan başlar.)
        Sheet sheet       = workbook.getSheetAt(0);
        // 1. satıra gidelim. (index değeri 0'dan başlar.)
        Row row           = sheet.getRow(0);
        // 1. Hücreyi alalım. (index değeri 0'dan başlar.)
        Cell ulkeler      = row.getCell(0);
        Cell baskentler   = row.getCell(1);
        Cell meshurlar    = row.getCell(2);
        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);
        // Excel'e Git -> Sheet 0'a git -> 3. İndexteki Satıra git -> 1. İndexteki HücreYI AL
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));
        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)

        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır sayısı : " + satirSayisi);
        // İçerisinde veri olan satır sayısını almak isterseniz
        // index'i 1'den başlıyor.
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu Satır Sayısı : " + doluSatirSayisi);
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum(); // 10
        // tüm ülkeleri yazdırdık
        for(int i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        // tüm başkentleri yazdıralım
        for(int j = 0 ; j <= sonSatirinIndexi ; j++){
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }
        // bir satırın son sütunun indexini alma
        // 1'den başlıyor
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);
        for(int k = 0; k < sonSutunIndex ; k++){
            System.out.println("4. Satır " + k +". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(k) );


        }
    }
}

/*
package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;


public class ReadExcel {
    @Test
    public void test() throws IOException {
        //Javada bir dosyayi acmak icin bu kullanilir.
        //Parametre bolumune acmak istedigimiz dosyanin adresi (dosya yolu-path )yazilir.
        FileInputStream fileInputStream=new FileInputStream("src/test/resources/ULKELER.xlsx");

           // Workbook (excel) dosyasını okumaya başladık.
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            //1. sayfaya gider (index degeri 0 dan baslar)

        Sheet sheet= workbook.getSheetAt(0);
        // 1. satira gider (index degeri 0 dan baslar)
     Row row =sheet.getRow(0);
     // 11. hucreyi alalim (index degeri 0 dan baslar)
     Cell cell=row.getCell(0);
     Cell ulkeler=row.getCell(0);
     Cell baskentler=row.getCell(1);
     Cell meshur=row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshur);

        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        //Son satir (row) in numarasini almak icin (index, index 0 dan baslar)

        int satirSayisi= workbook.getSheetAt(0).getLastRowNum()+1;
        System.out.println("Satir sayisi:"+ satirSayisi);

        //Icerisinde veri olan satir sayisini almak isterseniz
        //index i 1 den basliyor

        int doluSatirSayisi= workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu satir sayisi:"+ doluSatirSayisi);

      int sonSatirinIndexi= workbook.getSheetAt(0).getLastRowNum();

      for (int i=0; i<=sonSatirinIndexi; i++){
          System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
      }



        for (int i=0; i<=sonSatirinIndexi; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));

        }

        // bir satırın son sütunun indexini alma
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);

        for (int i=0; i<=sonSutunIndex-1; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(i));

        }

    }
}
 */