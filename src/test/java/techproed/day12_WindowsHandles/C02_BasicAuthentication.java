package techproed.day12_WindowsHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {

        //    Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        //    Başarılı girişi doğrulayın.


        //Basic authentication' larda kullanici adi ve sifrenin bize mutlaka verilmesi gerekir.
        //https://Kullanici Adi:Sifre@internetsitesi seklinde bir kullanimla handle edebiliriz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

        //Başarılı bir girişten sonra Congratulations! yazısının çıktığını doğrulayın.
        WebElement test = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(test.getText().contains("Congratulations!"));


        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString()); //Açılan yeni pencereye geçtik

        // Başlığın Elemental Selenium olduğunu doğrulayın
        System.out.println("Sayfa Başlığı" + driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium", driver.getTitle());

        //DDM den java seçilim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        /*
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
         */
        selectVisibleText(ddm, "Java"); //--> Method ile
    }
}
