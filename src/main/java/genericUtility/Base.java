package genericUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
   public DesiredCapabilities dc;
   public AppiumDriver driver;
   public AppiumDriverLocalService server;
    @BeforeSuite
    public void databaseConnection()
    {
        System.out.println("database connection established");
    }
    @BeforeClass
    public void startServer()
    {
        server= AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(4722));
        server.start();
    }

    @BeforeMethod
    public void launchApp() throws MalformedURLException {

        dc=new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        dc.setCapability(MobileCapabilityType.UDID,"a3bacc8f");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi note 7 pro");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability("appPackage","io.appium.android.apis");
        dc.setCapability("appActivity",".ApiDemos");
        URL url=new URL("http://localhost:4723/wd/hub");
        driver=new AppiumDriver(url,dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeApp()
    {
        driver.closeApp();
    }


    @BeforeClass
    public void stopServer()
    {
        server.stop();
    }

    @BeforeSuite
    public void closeDatabaseConnection()
    {
        System.out.println("database connection is closed");
    }
}
