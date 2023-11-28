package techproed.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators {
    @Test
    public void testLocators() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AndroidDriver driver = new AndroidDriver(url, options);

        //1.accessibilityId
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID : "+element.getText());
        System.out.println();

        //2.ID
        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);   //resource-id kullanılarak alınır
        System.out.println("ID : "+element.getText());
        System.out.println();

        //3.className
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("className : "+element.getText());
        System.out.println();

        //4.androidUIAutomator
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("androidUIAutomator : "+element.getText());
        System.out.println();

        //5.Xpad
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accessibility\"]"));
        System.out.println("Xpad : "+element.getText());
        System.out.println();

    }
}