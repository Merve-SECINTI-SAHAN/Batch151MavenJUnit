package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alert extends TestBase {
 /*
       Eğer bir sayfadaki bir butona tıkladığınızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ click
       yapıp locate alamıyorsak JS Alert'tir.
       JS Alert'ü handle edebilmek için driver'imizi o pencereye geçirmemiz gerekir.
       driver objenizi kullanarak switchTo() methoduyla alert() methodunu kullanarak JS Alert'e geçiş yapmış oluruz.
       accept() ya da dismis() methodlarıyla JS Alert'ü onaylar ya da iptal ederek kapatırız
        */



    @Test
    public void acceptAlert() { //Bir metod olusturun: acceptAlert
        //https://testcent er.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
      driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo(). //geçmek için kullanılan method
                alert(). //alert'e geçiş
                accept(); //çıkan alert'te ok ya da tamam butonuna tıklar.
        bekle(2);
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi= "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());
    }

    @Test
    public void dismissAlert() {  //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().
                alert().
                dismiss(); //JS Alert'teki iptal butonuna basar
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi= "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenYazi));
        bekle(2);

    }

    @Test //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    public void  sendKeysAlert() {  //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Merve");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);

        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi= "Merve";
        Assert.assertTrue(resultMessage.getText().contains(istenenYazi));
        bekle(2);


    }
}
