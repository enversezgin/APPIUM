package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C04_NativeElementleriTanimlama extends ApiDemosBaseTest {
    @Test
    public void testWebElements() throws MalformedURLException {
 //      String appUrl = System.getProperty("user.dir")
 //              + File.separator + "src"
 //              + File.separator + "test"
 //              + File.separator + "resources"
 //              + File.separator + "ApiDemos-debug.apk";
 //      UiAutomator2Options options = new UiAutomator2Options()
 //              .setApp(appUrl);
 //      URL url = new URL("http://0.0.0.0:4723");
 //      AndroidDriver driver = new AndroidDriver(url, options);

        WebElement app = driver.findElement(AppiumBy.accessibilityId("App"));
        app.click();    // click yapmazsak alttaki satırı bulamayacağı için (findElement) noSuchElement exception fırlatır.
        WebElement alarm = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();
        WebElement alarmController = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmController.click();


    }

    @Test
    public void testBy() throws MalformedURLException {
 //       String appUrl = System.getProperty("user.dir")
 //               + File.separator + "src"
 //               + File.separator + "test"
 //               + File.separator + "resources"
 //               + File.separator + "ApiDemos-debug.apk";
 //       UiAutomator2Options options = new UiAutomator2Options()
 //               .setApp(appUrl);
 //       URL url = new URL("http://0.0.0.0:4723");
 //       AndroidDriver driver = new AndroidDriver(url, options);

        By app = AppiumBy.accessibilityId("App");
        By alarm = AppiumBy.accessibilityId("Alarm");
        By alarm_controller = AppiumBy.accessibilityId("Alarm Controller");

        driver.findElement(app).click();    // bu satırları yazmazsam hata vermez çünkü yukarıda eylem yok
        driver.findElement(alarm).click();  // sadece tanımlama yapıldı. Eylem sadece bu satırladra bulunuyor.
        driver.findElement(alarm_controller);

    }
}
