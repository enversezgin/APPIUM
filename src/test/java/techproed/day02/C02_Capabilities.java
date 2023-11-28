package techproed.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {
    String appUrl = System.getProperty("user.dir")
            + File.separator + "src"        // File.separator farklı işletim sisteminde dosya dizini ayırmak için farklı
            + File.separator + "test"       // işaretler kullanımından dolayı kullanılır. Ornek windows \\ iken Mack / kullanır
            + File.separator + "resources"
            + File.separator + "ApiDemos-debug.apk";

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                //.setUdid("emulator-5554")
                .setApp(appUrl)    // Çalıştıracağımız uygulamayı seçmek için
                //               .setAppPackage("io.appium.android.apis")
                //               .setAppActivity("io.appium.android.apis.ApiDemos")
                .setAvd("Pixel_4_API_29")//AVD Id'si "" içine yazılır. Sanal cihaz açma bölümünde 3nokta tılanır oradan alınır
                .setAvdLaunchTimeout(Duration.ofMinutes(5)) // Emülatörün açılışında süre tanımlaması için
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

    }
}
