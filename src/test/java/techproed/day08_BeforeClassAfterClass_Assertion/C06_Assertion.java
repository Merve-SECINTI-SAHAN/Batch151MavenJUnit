package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
    Assertion'larda eşitlik için expected, actual olarak kullanılır.
     */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test02() {
        Assert.assertEquals(3,3);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test04() {
        String actualName= "erol";
        String expectedName= "erol";
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test05() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertTrue(emeklilikYas<yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test06() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertTrue(emeklilikYas>yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test07() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertFalse(emeklilikYas<yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }


}
