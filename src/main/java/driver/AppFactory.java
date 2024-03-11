package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.SkipException;

import com.score.base.AppData;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    static AppiumDriver driver;

    private static void android_launchApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("appium:appPackage", AppData.androidAppPackage);
        options.setCapability("platformName",AppData.androidPlatformName);
        options.setCapability("appium:platformVersion", AppData.androidPlatformVersion);
        options.setCapability("appium:appActivity", AppData.androidAppActivity);
        options.setCapability("appium:autoGrantPermissions", true);
        options.setCapability("appium:NO_RESET", AppData.noReset);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    private static void ios_launchApp() throws MalformedURLException, MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("appium:BundleId", AppData.IOSBundleID);
        options.setCapability("platformName",AppData.IOSPlatformName);
        options.setCapability("appium:platformVersion", AppData.IOSPlatformVersion);    
        options.setCapability("appium:autoAcceptAlerts", true);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if(AppData.platform.contains("android")){
        	android_launchApp();
        	System.out.println("Android App launched...");
        }else
            if(AppData.platform.contains("IOS")){
            	ios_launchApp();
                System.out.println("IOS launched...");
            }else
                throw new SkipException("Enter valid platform value, Android/IOS");
    }
}
