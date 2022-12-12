package TestCases;

import PageObjects.LoginPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC1_LoginPage extends BaseClass {


    @Test
    public void TC1() throws InterruptedException, IOException {

        driver.get(baseURL);
        logger.info("Navigating to the URL");

        LoginPage lp = new LoginPage(driver);
        Thread.sleep(3000);

        driver.manage().window().maximize();
        logger.info("Maximizing the window");

        lp.setEmail(username);
        logger.info("Entering username");

        lp.setPassword(password);
        logger.info("Entering password");

        lp.clickLoginbutton();
        logger.info("Press login button");

        if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage1234")){
            Assert.assertTrue(true);
            logger.info("User redirected to the correct page");
        }else {
            captureScreen(driver,"TC1");
            Assert.assertTrue(false);
            logger.info("User redirected to the wrong page");
        }

    }




}
