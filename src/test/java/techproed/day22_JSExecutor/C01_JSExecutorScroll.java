package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {
    //Javascript Executor javascript kodlarını java framework'ünde kullanabilmek için oluşturulan bir API'dir. Bu API Seleniumda gelir.
    //Selenium ile webelementlerin kontrolünü sağlarken selenium komutları yetersiz kalabilir veya sorunlarla karşulaşabiliriz.
    //Bu sorunda JS Executor kullanabiliriz.
    /*
Actions class'ındaki gibi js executor ile de sayfada scroll işlemi yapabiliriz. Bir webelementi locate edip
o webelement görünür olana kadar scroll yapabiliriz
"arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmiş olduğumuz webelemente scroll
yaparız
 */

    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); //reklamı kapattı

        // "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
       WebElement weofferWE= driver.findElement(By.xpath("//*[.='we offer']"));
        //js.executeScript("arguments[0].scrollIntoView(true)",weofferWE); bunun yerine method kullandık
        jsScrollWE(weofferWE);
        tumSayfaResmi();

        // Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE= driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        //js.executeScript("arguments[0].scrollIntoView(true)",enrollFreeWE); -->bunun yerine method kullandık
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        //js.executeScript("arguments[0].scrollIntoView(true);",whyUsWE);-->bunun yerine method kullandık
        jsScrollWE(whyUsWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
       // js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);-->bunun yerine method kullandık
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();


        //Sayfayı en alta scroll yapalım
       // js.executeScript("window.scrollTo(0,document.body.scrollHeight)");-->bunun yerine method kullandık
        scrollEnd();
        bekle(2);

        // Sayfayi en üste scroll yapalım
       // js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");-->bunun yerine method kullandık
        scrollHome();

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)"); //--> x=0, y=2000 pixel olarak bir noktaya scroll yapar
    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement WeOffer = driver.findElement(By.xpath("//*[.='we offer']"));
        jsScrollWE(WeOffer);
        bekle(2);
        tumSayfaResmi();
        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFree);
        bekle(2);
        tumSayfaResmi();
        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUs);
        bekle(2);
        tumSayfaResmi();
        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWE(enrollFree);
        bekle(2);
        tumSayfaResmi();
        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(2);
        tumSayfaResmi();
        //Sayfayi en üste scroll yapalım
        scrollHome();
        bekle(2);
        tumSayfaResmi();
    }
}
