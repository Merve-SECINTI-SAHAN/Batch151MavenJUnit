package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
        Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip
        inmediğini kontrol etmek varlığını doğrulayabilmek için
         ya da bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek için
         Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
         dosyanın varlığını tesst edebiliriz. --> Files.exists(Paths.get(dosyaYolu))
         Dolayısıyla bu işlem başlamadan önce dosya varlığını test edeceğiniz dosyanın yolunu String bir değişkene
         assign ederiz.


NOT:
    Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
    yolunu almak istediğimiz dosyanun üzerine gelip shift+sayKlik tusuna basarak yol olarak kopyala
    seçeneği ile dosya yolunu kopyalayabiliriz.

         */
        String dosyaYolu= "C:/Users/secin/OneDrive/Masaüstü/SQL.docx/";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); //--> Dosya varsa true, yoksa false döner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test02() {
        String dosyaYolu= "C:/Users/secin/OneDrive/Masaüstü/Alberto_ceviri_V2 (1).pdf";
        //--> "C" den once ve en sondaki cift tirnaktan once /" olmayacak

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //--> Dosya varsa true, yoksa false döner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test03() throws InterruptedException {
        /*
       Bir server'da farkli isletimsistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman,
daha dinamik olmasi acisindan System.getProperty("os.name") bu sekilde isletim sistemini alir
her isletim sisteminin kullanici yolu farkli olacagindan  System.getProperty("user.home")
ile bilgisayarimizdaki kullanici yolunu alip bu sekilde String  bir degiskene farkli yol ismi ileSystem.getProperty("user.home")
atayarak her seferinde farkli yollari almayla ugrasmamis oluruz. Dosya diyelimki masaustunde ve her isletim
sisteminde bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assign ederiz.

         */
        //-->Dosya yolumuz : "C:/Users/secin/OneDrive/Masaüstü/Alberto_ceviri_V2 (1).pdf"
        // Farklı yol "C:/Users/secin
        // Ortak yol: /OneDrive/Masaüstü/Alberto_ceviri_V2 (1).pdf"
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/Alberto_ceviri_V2 (1).pdf";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu)); //-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
            //deleteIfExists kullanırsak try e gerek mi kalmıyor hocam
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu))); //--> Sildiğimiz için assertFalse kullandık

        Thread.sleep(3000);
        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Her seferiinde test ettiğimiz sayfada işlemi yapılıyorsa gereksiz dosya kalabalığı önlemek için
        yukardaki delete işlmemini kullanabiliriz.
         */
    }

    @Test
    public void test04() {
        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */
        String dosyaYolu= "C:/Users//secin/OneDrive/Masaüstü/sennnn.txt";
        File file= new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();

    }
}

