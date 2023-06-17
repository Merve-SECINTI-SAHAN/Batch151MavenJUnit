package techproed.day13_Cookies_Actions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.ArrayList;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin

        ArrayList<Cookie>cookiesList= new ArrayList<>(driver.manage().getCookies());
        System.out.println(cookiesList.size());



        int counter= 1;
        for (Cookie w:cookiesList) {
            System.out.println(counter+"'inci çerez : " +w);
            System.out.println(counter+ ". cookie : "+w.getName() + " = "+w.getValue());
            counter++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(cookiesList.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gercek
        // degerini actualCookieValue degiskenine assign ettik

        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        Cookie newCookie = new Cookie("mustafa", "aydin");
        driver.manage().addCookie(newCookie);

        cookiesList = new ArrayList<>(driver.manage().getCookies());

        System.out.println(cookiesList.size());
        for (Cookie each:cookiesList) {
            System.out.println(each);

        }


        driver.manage().deleteCookieNamed("mustafa");

        cookiesList = new ArrayList<>(driver.manage().getCookies());

        System.out.println(cookiesList.size());
        for (Cookie each:cookiesList) {
            System.out.println(each);
        }










    }
}