package TestPackage;

import Libs.Base;
import Libs.KeywordOperations;
import PageObjects.MainPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by kamzaidi on 04-09-2018.
 */
public class Header extends Base{

    /* Cookies Method*/


    public static void cookiesCheck (WebDriver driver){

        etest = extent.startTest(" Check Cookies Method Is Running");

        MainPageObject MO = PageFactory.initElements(driver,MainPageObject.class);

        KeywordOperations.sectionDisplayed(MO.cookiesSection,"Cookies Section");        //Check Cookies Section
        KeywordOperations.getText(MO.getFirstCookiesText);                              //Get First Text
        KeywordOperations.getText(MO.getSecondCookiesText);                             //Get Second Text
        KeywordOperations.toClick(MO.clickMoreCookies);                                 //Click on Click Here for more
        KeywordOperations.toClickWithText(MO.cancelCookies,"Cancel Cookie");            //Cancel Cookies

    }



}
