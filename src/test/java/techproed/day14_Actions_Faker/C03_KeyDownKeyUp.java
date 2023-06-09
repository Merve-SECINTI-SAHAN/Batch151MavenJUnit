package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //google anasayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusunda Shift tuşuna basılı olarak selenium yazdıralım ve shift tuşuunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT). //--> arama kutusunda shift tuşuna bastık
                sendKeys("selenium").
                keyUp(Keys.SHIFT). // --> shift tuşunu serbest bıraktık
                sendKeys("-java", Keys.ENTER).
                perform();

    }

    @Test
    public void test02() {
        //google anasayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusunda Shift tuşuna basılı olarak selenium yazdıralım ve shift tuşuunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"Selenium",Keys.SHIFT,"-java",Keys.ENTER);

/*
mouse islemlerini kullanmak icin (pageup-down, double click, sag click, mouseu götür) actions kullaniriz.
klavye islemlerinde actions a gerek yoktur
*/

        /*
        Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
         */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium", Keys.ENTER);

        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")). //sayfa yenilendiği için tekrar locate aldık
        sendKeys(Keys.CONTROL,"a"); //metni alabilmemiz için önce ctrl+a ile seçmemiz gerekir

        driver.findElement(By.xpath("//*[@class='gLFyf']")). //sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"x");

        // Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER); //--> Kestiğimiz metni ctrl+v ile tekrar arama kutusuna yapıştırdık ve arattık

    }
}
