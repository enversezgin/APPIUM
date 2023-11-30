package techproed.day04practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;

import java.util.List;

public class P02_GeneratorStore extends GeneralStoreBaseTest {
    /*
    Uygulama: GeneralStore
GeneralStore uygulamasına gir
Menüden Angola seçeneğini seç
Your Name kutusuna Safinaz yaz
Gender bölümünden Female seçeneğini seç
Let’s Shop butonuna tıkla
Ürün listesindeki iki ürünü sepete ekle
Sepete gir
Sepette iki ürün olduğunu doğrula
Ürün fiyatlarını topla
Total Purchase Amount bölümündeki tutarın doğru olduğunu doğrula
Send me e-mails.. kutusunu seç
Visit to the website.. butonuna tıkla
     */

    @Test
    public void testGeneralStore() throws InterruptedException {

        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        WebElement angola = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Angola\"]"));
        angola.click();

        WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");

        WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();

        WebElement button = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        button.click();

        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
        /*
        birinci clic sonrasında 1. olarak gördüğümüz element tıklandığı ve locete kaybolduğu için 2. olarak gördüğümüz element
        1. olarak güncellendi, bu yüzden iki satırda da get(0) şeklinde kullanldık ve bu sayede ilk 2 ürünü seçmiş olduk.
        */
        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(), 2);

        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
            String priceText = products.get(i).getText(); // $160.97 --> $120.0
            double price = Double.parseDouble(priceText.substring(1)); // 160.97  --> 120.0
            total += price;
        }
        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(total, totalAmount);
        Thread.sleep(3000);

        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();

    }
}
