package Libs;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by kamzaidi on 05-09-2018.
 */
public class Base {

    public static WebDriver driver;
    public static Logger log = Logger.getLogger(Base.class);
    public static ExtentReports extent;
    public static ExtentTest etest;
    public static Properties getProp;
    long millis = System.currentTimeMillis();
    public String driverLocation = "src/main/resources/Drivers";
    public String generateReport = "reports/detailTestReport_" +  millis + ".html";
    public String propertiesLocation =  "src/main/resources/data.properties";
    public static String MAIN_URL;
    public static String QA_URL;
    public static String getBrowser;
    public static String getTestName;



    @BeforeSuite
    public void KickingFramework() throws IOException {

        //Initializing Reports
        extent = new ExtentReports(generateReport, true);
        extent.startReporter(ReporterType.DB, (new File(generateReport)).getParent() + File.separator + "extent.db");
        extent.addSystemInfo("Log File","applog.log");
        log.info("Report location: " + generateReport);
        etest = extent.startTest("EXTENT REPORT INITIALIZED");


        //Initializing Properties
        getProp = new Properties();
        FileInputStream inputStream = new FileInputStream(propertiesLocation);
        getProp.load(inputStream);

        //Initializing Driver
        InitializeDriver();
        InitializingURL();
    }


    public WebDriver InitializeDriver() throws IOException {

        String getAbsolutePath = new File(driverLocation).getAbsolutePath();

        // Getting URL/Browser From Property File
        MAIN_URL = getProp.getProperty("mainUrl");
        QA_URL=getProp.getProperty("qaURL");
        getBrowser = getProp.getProperty("browser");
        //getTestName = getProp.getProperty("runTest");


        if(getBrowser.equalsIgnoreCase("chrome")){

            //CHROME
            System.setProperty("webdriver.chrome.driver", getAbsolutePath+"/chromedriver.exe");
            driver=new ChromeDriver();

        }else if(getBrowser.equalsIgnoreCase("IE")){

            //INTERNET EXPLORER
            System.setProperty("webdriver.ie.driver",getAbsolutePath+"/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }else if (getBrowser.equalsIgnoreCase("Firefox")){

            //FIREFOX
            System.setProperty("webdriver.gecko.driver",getAbsolutePath+"/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        etest.log(LogStatus.INFO,"Starting "+getBrowser+" Browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;

    }


    public void InitializingURL() throws IOException {

        try{

            String getURL = getProp.getProperty("environment");

            if(getURL.equalsIgnoreCase("QA")){

                driver.get(QA_URL);
                log.info("QA URL : " +QA_URL);
                etest.log(LogStatus.INFO, "QA URL : "+QA_URL);
                etest.log(LogStatus.INFO,"ENVIRONMENT : "+getProp.getProperty("environment")+" - Environment");

            }else if(getURL.equalsIgnoreCase("Production")){

                driver.get(MAIN_URL);
                log.info("PRODUCTION URL : "+MAIN_URL);
                etest.log(LogStatus.INFO, "PRODUCTION URL : "+MAIN_URL);
                etest.log(LogStatus.INFO,"ENVIRONMENT : "+getProp.getProperty("environment")+" - Environment");

            }

            log.info("URL OPENED :- "+getProp.getProperty("mainUrl"));


        }catch (Exception e){

            e.printStackTrace();
        }


    }

    @BeforeMethod
    public void nameBefore(Method method)
    {
        etest.log(LogStatus.INFO,method.getName()+" :  is Running");
        log.info(method.getName()+" :  is Running");
    }

    @AfterTest
    public void shutDown(){

        extent.flush();
        driver.close();

    }

}
