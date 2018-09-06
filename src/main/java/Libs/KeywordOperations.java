package Libs;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;

/**
 * Created by kamzaidi on 28-08-2018.
 */
public class KeywordOperations extends Base {


    public static void toClick(WebElement element){

        String getlinkText = element.getText();
        try {

            //String getlinkText = element.getText();
            element.click();
            log.info("Element - "+getlinkText+"- Clicked");
            etest.log(LogStatus.PASS,"Clicked On - "+getlinkText+" - Successfully");

        }catch (Exception e){


            log.error("Unable To Click On : "+getlinkText+"");
            log.error(e);
            etest.log(LogStatus.FAIL, "Unable To Click On : "+getlinkText);
            etest.log(LogStatus.ERROR,e);
        }


    }
    public static void toClickWithText(WebElement element,String text){

        try {

            element.click();
            log.info("Element - "+text+"- Clicked");
            etest.log(LogStatus.PASS,"Clicked On - "+text+" - Successfully");

        }catch (Exception e){


            log.error("Unable To Click On : "+text+"");
            log.error(e);
            etest.log(LogStatus.FAIL, "Unable To Click On : "+text);
            etest.log(LogStatus.ERROR,e);
        }


    }
    public static void sectionDisplayed(WebElement element, String text){

        try {
            Boolean getResult = element.isDisplayed();

            if(getResult==true){

                log.info( text+": Section is Displayed " );
                etest.log(LogStatus.PASS,text+" : Section Is Displayed ");

            }else {

                log.info( text+ ": Section is not Displayed " );

            }
        }catch (Exception e ){

            etest.log(LogStatus.FAIL,text+" : Section Is Not Displayed ");
            etest.log(LogStatus.ERROR,e);

        }

    }
    public static void getText(WebElement element){

        try {

            String getAllText = element.getText();
            log.info( "Text Fetched :" +getAllText);
            etest.log(LogStatus.PASS," Text Fetched : "+getAllText+"");

        }catch (Exception e){

            log.error(e);
            etest.log(LogStatus.FAIL," Unable To Fetch The Text");
            etest.log(LogStatus.ERROR,e);
        }


    }
}
