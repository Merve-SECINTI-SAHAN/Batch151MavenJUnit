package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {

    @Test
    public void test01() {
         /*
        Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api' dir.
            Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hem de src>main>resources icine
        koydugumuz log4j.xml file da belirttigimiz .log uzantili dosyada yine tarih saat olarak kayit altina almis olacagiz.
        log4j kullanabilmek için öncelikle log4j-api ve log4j-core depency'lerini mvnrepository.com adresinden
        (aynı versiyon numaralarına sahip) alıp pom.xml dosyamıza koymalıyız.
        src>mainZresources içine koyduğumuz Log4j.xml dosyasındaki kodlara pdf deki adresten
        ulaşabilirsiniz.
         */

        Logger logger= LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");

    }
}
