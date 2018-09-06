package RunPackage;

import Libs.Base;
import TestPackage.Header;
import org.testng.annotations.Test;

/**
 * Created by kamzaidi on 05-09-2018.
 */
public class MainPage extends Base{

    @Test
    public void  runMethods(){

        //Get Testing Name To Perform
        getTestName = getProp.getProperty("runTest");

        if(getTestName.equalsIgnoreCase("Regression")){

            etest=extent.startTest("PERFORMING REGRESSION");
            Header.cookiesCheck(driver);

        }else if (getTestName.equalsIgnoreCase("Smoke")){

            etest=extent.startTest("PERFORMING SMOKE");
            Header.cookiesCheck(driver);

        }else if (getTestName.equalsIgnoreCase("Sanity")){

            etest=extent.startTest("PERFORMING SANITY");
            Header.cookiesCheck(driver);

        }
    }
}
