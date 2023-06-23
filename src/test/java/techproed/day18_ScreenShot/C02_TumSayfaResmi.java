package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        bekle(2);

        // Ve ekran görüntüsünü alalım

        String tarih= new SimpleDateFormat("__hh__mm__ss__ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpg";
        TakesScreenshot ts= (TakesScreenshot) driver;
       // FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));



    }
}
