package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {
    @Test
    public void test01() {

        // Test Görevi:

//https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

//Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String actualURL="https://www.kitapyurdu.com/";
        String expectedURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);


//Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
        String actualTitle= "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String expectedTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

//Anasayfada bazı başlıklarının bulunduğunu doğrulayınız.
        String pageSource= driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

//Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisButonu= driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisButonuMetni=girisButonu.getText();
        Assert.assertEquals(girisButonuMetni,"Giriş Yap");

//“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlHref);

//En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsmiListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarIsmiListesi){
            Assert.assertEquals("span", yazarIsmi.getTagName());
        }

//En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
        for (WebElement yazarIsmi : yazarIsmiListesi){
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }

//Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin(width) 120, yüksekliğinin(height) 174 olduğunu doğrulayınız.

        WebElement ilkKitapGenislikYukseklik= driver.findElement(By.xpath("(//img)[53]"));
        int height= ilkKitapGenislikYukseklik.getSize().getHeight();
        int width= ilkKitapGenislikYukseklik.getSize().getWidth();
        Assert.assertEquals(height,52);
        Assert.assertEquals(width,52);




//quit() ve close() metotları arasındaki farkı inceleyelim.

        driver.close();
    }
    }

