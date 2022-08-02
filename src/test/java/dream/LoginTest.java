package dream;

import ObjectRepository.LoginPage;
import genericUtility.Base;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test
    public void clickOnView()
    {
        //change four new
        LoginPage lpage=new LoginPage(driver);
        lpage.clickOnContinue();
        lpage.clickOnOkayButton();
        lpage.clickViews();
    }

}
