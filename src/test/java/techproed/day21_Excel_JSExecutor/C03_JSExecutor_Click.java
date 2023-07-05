package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
      Bir web sayfasında bazı webelementler oluştururlurken JAVASCRIPT kodlarıyla oluşturulmuş olabilir.
      Bu webelementleri handle edebilmek için JavaScriptExecutor arayüzünü kullanmamız gerekir.
      Bir webelement JavaScript kodları ile yazılmamış olsa da JavaScriptExecutor ile o elementi handle edebiliriz.
      Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa onları kullanırız.
       <script> tagı ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.

       */
    @Test
    public void test01() {
        //amazon sayfasına gidiniz.
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementResmi(sellLinki); //testBase'den method çağırdık

        //Sell linkine executor kullanarak tıklayınız
      // WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));--> yukarda yazdığımız için tekrar yazmaya gerek yok
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //SAyfanın resmini alalım
        tumSayfaResmi();
    }
    //Yukarıdaki şekilde yazdığımızda istediğimiz WE değil onun önüne çıkan webelementin resmini alıyor.

    @Test
    public void test02() {
        //amazon sayfasına gidiniz.
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementResmi(sellLinki); //testBase'den method çağırdık

        //Sell linkine tıklayınız
        // WebElement sellLinki= driver.findElement(By.xpath("//*[text()='Sell']"));--> yukarda yazdığımız için tekrar yazmaya gerek yok
        sellLinki.click();
        /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direkt ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //SAyfanın resmini alalım
        tumSayfaResmi();

        /* sellLinki.click(); kullandığımız için WE resmini almıyor, ElementClickInterceptedException hatası veriyor.
        ("Tıklama Engellemesi Oluşturan Eleman İstisnası" anlamına gelir)
        Bir web sayfasında bir öğeye (element) tıklamak istediğinizde, bazen başka bir öğe veya sayfa bileşeni tıklama
        işlemini engelleyebilir. Örneğin, bir öğe diğer bir öğenin üzerinde yer alabilir veya sayfa yüklenirken
        bir animasyon öğesi tıklama işlemini engelleyebilir.
         */

    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        //driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı

        WebElement sellLinki = driver.findElement(By.xpath("//*[text()='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);//-->Click methodu ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();




    }
}
