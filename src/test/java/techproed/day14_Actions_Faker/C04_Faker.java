package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {
    @Test
    public void faker() {

        /*
        Faker class'ından sahte verileri kullanabilmek için obje oluşturmamız gerekir.

         */
        Faker faker= new Faker();

        //faker objesini kullanarak bir isim yazdiralim
        System.out.println("İsim: "+faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("Soyisim: "+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("İsim Soyisim: "+faker.name().fullName());


        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Adres: "+faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println("Cep_No: "+faker.phoneNumber().cellPhone());
        System.out.println("Tel_No: "+faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli bir numara: "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());

    }
}