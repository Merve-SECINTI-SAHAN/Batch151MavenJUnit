package automation_exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class TestCase4 extends TestBase {

    @Test
    public void test01() {

        // 1. Launch browser -- Tarayıcıyı başlat
        extentReport("Chrome","AutomationTest/TestCase4");
        extentTest= extentReports.createTest("ExtentReport","Test Raporu");


        // 2. Navigate to url 'http://automationexercise.com' --http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        extentTest.info("Sayfaya gidildi");

        // 3. Verify that home page is visible successfully-- home page'în başarıyla göründüğünü doğrulayın
        WebElement homePage = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        assert homePage.isDisplayed();
        webElementResmi(homePage);
        extentTest.info("Home Page'in görünür olduğu doğrulandı.");


        // 4. Click on 'Signup / Login' button --Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement signUpLogin= driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpLogin.click();
        //webElementResmi(signUpLogin);
        extentTest.info("Sign Up/Login butonuna click yapıldı");

        // 5. Verify 'Login to your account' is visible-- Hesabınızda oturum açın'ın görünür olduğunu doğrulayın
        WebElement LoginToYourAccount= driver.findElement(By.xpath("(//h2)[1]"));
        assert LoginToYourAccount.isDisplayed();
        extentTest.info("Login to your account'un görünür olduğu doğrulandı");
        webElementResmi(LoginToYourAccount);


        // 6. Enter correct email address and password-- Doğru e-posta adresini ve şifreyi girin
        // 7. Click 'login' button --Giriş' düğmesine tıklayın
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("mustafasagiroglu06452@gmail.com" + Keys.TAB, "Password" + Keys.TAB,Keys.ENTER);
        extentTest.info("Kullanıcı adı ve mail ile giriş yapıldı");

        // 8. Verify that 'Logged in as username' is visible-- Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement LoggedInAs= driver.findElement(By.xpath("//li[10]//a[1]"));
        assert LoggedInAs.isDisplayed();
        extentTest.info("Logged in as Mustafa'nın görünür olduğu doğrulandı");
        webElementResmi(LoggedInAs);

        // 9. Click 'Logout' button --Çıkış' düğmesine tıklayın
        WebElement logout= driver.findElement(By.xpath("//a[@href='/logout']"));
        logout.click();
        extentTest.info("Logout tuşuna click yapıldı.");
        //webElementResmi(logout);


        // 10. Verify that user is navigated to login page--Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        extentReports.flush();




    }
}
