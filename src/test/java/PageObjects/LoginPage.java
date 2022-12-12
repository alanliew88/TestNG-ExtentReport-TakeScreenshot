package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;
    public LoginPage (WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);

    }

    @FindBy(xpath = "/html/body/form/table/tbody/tr[1]/td[2]/input" )
    @CacheLookup
    WebElement Emailtxtbox;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input" )
    @CacheLookup
    WebElement Passwordtxtbox;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
    @CacheLookup
    WebElement Loginbutton;

    public void setEmail (String email){
        Emailtxtbox.clear();
        Emailtxtbox.sendKeys(email);
    }

    public void setPassword (String Password){
        Passwordtxtbox.clear();
        Passwordtxtbox.sendKeys(Password);
    }

    public void clickLoginbutton (){

        Loginbutton.click();
    }

    public String getTitle(){

        return ldriver.getTitle();
    }


}
