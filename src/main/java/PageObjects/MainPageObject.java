package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kamzaidi on 03-09-2018.
 */
public class MainPageObject {

    final WebDriver driver;

    public MainPageObject(WebDriver driver){

        this.driver=driver;

    }

    @FindBy(xpath = "(//div[@id='cookie-banner'])[1]")
    public WebElement cookiesSection;

    @FindBy(xpath = "(//div[@id='cookie-banner'])[1]/section/p")
    public WebElement getFirstCookiesText;

    @FindBy(xpath = "(//div[@id='cookie-banner'])[1]/section/div/p")
    public WebElement getSecondCookiesText;

    @FindBy(xpath = "(//div[@id='cookie-banner'])[1]/section/div/p/a")
    public WebElement clickMoreCookies;

    @FindBy(xpath = "(//div[@id='cookie-banner'])[1]/section/a")
    public WebElement cancelCookies;

}
