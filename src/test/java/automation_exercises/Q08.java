package automation_exercises;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;
import java.util.Random;

public class Q08 extends TestBase {
    int actualResult;
    @Test
    public void test01() throws InterruptedException {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Random random = new Random();
        int randomNumber1 = random.nextInt(9) + 1;
        int randomNumber2 = random.nextInt(9) + 1;
        /*
         for (int i = 0; i < 2; i++) {
            random = new Random();
            int randomSayi = random.nextInt(9)+1;
            driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

        }
         */


        WebElement one = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[" + randomNumber1 + "]"));
        one.click();
        WebElement two = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[" + randomNumber2 + "]"));
        two.click();

        int randomNumber3 = random.nextInt(4)+1 ;

        WebElement sign = driver.findElement(By.xpath("(//span[@class='operator btn btn-outline-success'])[" + randomNumber3 + "]"));
        sign.click();

        int randomNumber4 = random.nextInt(9) + 1;
        int randomNumber5 = random.nextInt(9) + 1;


        WebElement three = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[" + randomNumber4 + "]"));
        three.click();
        WebElement four = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[" + randomNumber5 + "]"));
        four.click();


        //Sonucu konsola yazdırıp
        //esittir tikla
        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();


        //sonucu yazdir
        WebElement result = driver.findElement(By.xpath("//div[@class='screen']"));


        //Thread.sleep(5000);



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@class='screen']"), result.getText()));
        System.out.println(result.getText());


        //Sonucun doğrulamasını yapalım

        int number1 = Integer.valueOf(one.getText() + "" + two.getText());
        System.out.println("number1 = " + number1);

        int number2 = Integer.valueOf(three.getText() + "" + four.getText());
        System.out.println("number2 = " + number2);


        if (sign.equals("+")) {
            actualResult = number1 + number2;
            String expected = result.getText();
            System.out.println("expected = " + expected);
            Assert.assertEquals(expected, actualResult);
        } else if (sign.equals("-")) {
            actualResult = number1 + number2;
            String expected = result.getText();
            System.out.println("expected = " + expected);
            Assert.assertEquals(expected, actualResult);
        } else if (sign.equals("*")) {
            actualResult = number1 * number2;
            String expected = result.getText();
            System.out.println("expected = " + expected);
            Assert.assertEquals(expected, actualResult);
        } else if (sign.equals("/")) {
            actualResult = number1 / number2;//0,21212123
            String expected = result.getText();
            System.out.println("expected = " + expected);
            Assert.assertEquals(expected, actualResult);
        }



        //   String expected = result.getText();
        //   System.out.println("expected = " + expected);
        //   Assert.assertEquals(expected, actualResult);


    }
}