package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;

public class LocalMobileDriver implements WebDriverProvider {
    static LocalConfig config = ConfigFactory.create(LocalConfig.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.localUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.platformName())
                .setDeviceName(config.deviceName())
                .setPlatformVersion(config.platformVersion())
                .setApp(getApk().getAbsolutePath())
                //                .setLocale("ru")
               // .setLanguage("ru")
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApk() {
        return new File("src/test/resources/app/app-wildberries-4.9.9.apk");
    }
}
