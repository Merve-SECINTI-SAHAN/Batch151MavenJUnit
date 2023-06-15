package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
    Bir HTML dokümanının içine yerleştirilmiş başka bir HTML dokümanına inline frame
    yani IFRAME denir. Bir sayfada iframe varsa iframe içindeki webelementi handle edebilmek için
    switchTo() methoduyla iframe'e geçiş yapmamız gerekir. Eğer geçiş yapmazsak nosuchelementexception alırız.

    Alert'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. iframe olsa da locate ederiz fakat handle edemeyiz

     */

    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");



        // Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin= driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        // Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->geçiş yapmazsak Nosuchelementexception hatası alırız
        String ApplicationslistsYazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(ApplicationslistsYazisi);
        Assert.assertEquals("Applications lists",ApplicationslistsYazisi);


        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().defaultContent();
        driver.get(driver.getCurrentUrl());
        driver.navigate().refresh();
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

    }
}
