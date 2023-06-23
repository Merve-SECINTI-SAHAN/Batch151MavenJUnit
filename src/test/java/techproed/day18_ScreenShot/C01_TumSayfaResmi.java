package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {

    @Test
    public void test01() throws IOException {
        /*
        SCREENSHOT
        Selenium'da tüm ekran görüntüsünü alabilmek için TakeScreenShot arayüzünden bir obje oluşturup
        driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız ve bu oluşturduğumuz obje ile
        getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
        oranın yolunu belirtiriz.
         */

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        // Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // Ve ekran görüntüsünü alalım

             //--->İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
         String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot.jpg";

            //--->İkinci olarak TakesScreeShot arayüzünden obje oluşturuyoruz
        TakesScreenshot ts= (TakesScreenshot) driver;

            //---> Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        //dosya yolunu belirteceğiz.
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("techproed/ScreenShot/screenShot.png"));
    }

    @Test
    public void test03() throws IOException {
        /*
Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
String bir değişkene tarih formatı atayabiliriz.
 */
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        // Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // Ve ekran görüntüsünü alalım

 /*
    SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz. Ve bunu dosya isminden once
    belirtiriz.
 */
        String tarih= new SimpleDateFormat("__hh__mm__ss__ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        bekle(2);

        // Ve ekran görüntüsünü alalım

        String tarih= new SimpleDateFormat("__hh__mm__ss__ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));



    }
}
