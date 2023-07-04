package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Odev1 {

    /*
        ODEV1
            1.satirdaki 2.hucreye gidelim ve yazdiralim
            1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
 -----  2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
            Satir sayisini bulalim
            Fiziki olarak kullanilan satir sayisini bulun
            Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
         */

    @Test
    public void name() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //1.satirdaki 2.hucreye gidelim ve yazdiralim
       String firstTask= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("FirstTask :" +firstTask);


        //--2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
        String actual= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expected= "Kabil";
        Assert.assertEquals(expected,actual);

        // Satir sayisini bulalim
        System.out.println("Satır Sayısı: "+workbook.getSheet("Sayfa1").getLastRowNum());

        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Kullanılan Satır Sayısı: "+workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String, String> ulkeBaskent = new HashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            String ulke= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,baskent + "\n");

        }
        System.out.println(ulkeBaskent);

    }


}
