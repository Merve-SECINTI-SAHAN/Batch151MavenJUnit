package techproed.day21_Excel_JSExecutor;

import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;
import techproed.utilities.TestBase;

public class Odev3 extends TestBase {
    /*
    sayfaya gidin cerezi kapatin
    https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE
     */

    @Test
    public void test01() {
        driver.get(" https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

    }
}

