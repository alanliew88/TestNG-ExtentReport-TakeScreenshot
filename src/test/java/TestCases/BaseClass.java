package TestCases;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    ReadConfig rc = new ReadConfig();

    public String baseURL = rc.getApplicationURL();

    public String username = rc.getUsername();

    public String password = rc.getPassword();

    public static WebDriver driver;

    public static Logger logger;

    @Parameters({"browser"})
    @BeforeTest
    public void Setup(String br){

        logger = Logger.getLogger("Hybrid Framework");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
    }


    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver,String tname)throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot Taken");
    }




}
