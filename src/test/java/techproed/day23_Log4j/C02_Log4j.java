package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Log4j extends TestBase {
    @Test
    public void test01() {
        Logger logger= LogManager.getLogger(C02_Log4j.class);
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        logger.info("Techpro Sayfasina Gidildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        logger.info("Sayfada Cikan Reklam Kapatildi");

        //Baslığın Egitim içerdigine dogrulayalım
        Assert.assertFalse(driver.getTitle().contains("Egitim"));
        logger.error("Sayfa başlığı Egitim yazısı içermiyor");
    }
}
