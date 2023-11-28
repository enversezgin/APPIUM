package techproed.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {
    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
//     bu kod dizini çalıştırılmadan önce bilgisayarda CMD çalıştırılır ve siyah ekrana appium yazılarak
//    sanal sorver aktif edilier

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("testDesiredCapabilities", "android");   // Zorunlu
        capabilities.setCapability("automationName", "uiautomator2");       // Zorunlu
//        capabilities.setCapability("udid", "emulator-5554");    // Birden fazla cihaz kullanılıyorsa zorunlu tek cihazda zorunlu değil
        capabilities.setCapability("app", "C:\\Users\\enver\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk");
//       capabilities.setCapability("appPackage","io.appium.android.apis");
//       capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);

    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                //.setUdid("emulator-5554")
                .setApp(appUrl)
                //               .setAppPackage("io.appium.android.apis")
                //               .setAppActivity("io.appium.android.apis.ApiDemos")
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

    }
}
