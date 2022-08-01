package ObjectRepository;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="com.android.permissioncontroller:id/continue_button")
    private MobileElement continueButton;

    @FindBy(id="android:id/button1")
    private MobileElement okayButton;

    @FindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
    private MobileElement views;

    public LoginPage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public MobileElement getContinueButton()
    {
        return continueButton;
    }
    public MobileElement getOkayButton()
    {
        return okayButton;
    }

    public MobileElement getViews()
    {
        return views;
    }



    public void clickOnContinue()
    {
        continueButton.click();
    }
    public void clickOnOkayButton()
    {
        okayButton.click();
    }
    public void clickViews()
    {
        views.click();
    }
}
