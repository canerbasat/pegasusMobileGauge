import com.kebab.DriverSetup;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mapping.Mapper2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class StepImplementation extends DriverSetup {
    Mapper2 mapper2 = new Mapper2();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    TouchAction action;


    @Step("<Saniye> Saniyesi kadar bekle")
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<by> butonuna tıklanır")
    public void clickElement(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).click();
    }

    @Step("<by> alanına <text> yazılır")
    public void sendKeys(String by, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).sendKeys(text);
    }

    @Step("<by> alanı silinir")
    public void deleteTextbox(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).clear();
    }

    @Step("<by> elementinin görülmesi beklenir")
    public void waitForTheElement(String by) {
        assertTrue(by + " elemanı sayfada görülemedi!",
                wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).isDisplayed());
    }

    @Step("Herhangi bir pop up varsa kapatılır")
    public void closeThePopUps() {
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().dismiss();
        }
    }

    @Step("Klavyeden TAB tuşuna basılır")
    public void pressTAB() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
    }

    @Step("Klavyeden ENTER tuşuna basılır")
    public void pressENTER() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
    }

    @Step("Klavyeden <text> yazdırılır")
    public void sendString(String text) {
        driver.findElement(By.tagName("body")).sendKeys(text);
    }

    @Step("<> listesinden İlk elementi sec")
    public void chooseFirst(String bsy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(bsy))).findElement(By.id("")).getLocation();


    }


    @Step("<a>Listedesindeki <a> element secilir ")
    public void selectAndClickTextFromList(List<MobileElement> list, String text) {
        boolean elementIsFound = false;
        for (MobileElement item : list) {
            if (item.getText().equals(text)) {
                elementIsFound = true;
                item.click();
                break;
            }
        }
        assertTrue(text + " butonu bulunamadı", elementIsFound);
    }



    @Step("Bugunun Tarihi secilir")
    public void chooseToday() {
        int i = 0;
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        i = calendar.get(Calendar.DAY_OF_MONTH)+1;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.pozitron.pegasus:id/list_item_date_selection_days_text_view' and @enabled='true' and @text='" + i + "']"))).click();
    }


    @Step("Ucus tarihi tablosundan <day> 'u secilir")
    public void chooseDaySpecial(int day) {
        int i = 0;
        i = day;
        driver.findElement(By.xpath("//*[@resource-id='com.pozitron.pegasus:id/list_item_date_selection_days_text_view' and @enabled='true' and @text='" + i + "']")).click();
    }

    @Step("Size")
    public void swipeSize() {
     /*   Dimension screenSize = driver.manage().window().getSize();
        new TouchAction(driver)
            //    .press((int) (screenSize.width * 0.6), 130)
                .waitAction(500)
                .press((int) (screenSize.width * 0.3), 130)
                .release()
                .perform();*/
    }

    @Step("Sayfanın sonuna kadar swipe yapılır")
    public void scrollDownToBottom() {
        for (int i = 0; i <= 3; i++)
            (new TouchAction(driver))

                    .press(PointOption.point(546, 1417))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(557, 559))
                    .release()
                    .perform();
    }

    @Step("Listenin son ucusu secilir")
    public void takeLastOption() {

        List<MobileElement> all = driver.findElements(By.xpath("//*[@resource-id='com.pozitron.pegasus:id/list_item_availability_flight_text_view_cheapest_price' and @enabled='true']"));
        String[] allText = new String[all.size()];
        int i = 0;
        for (MobileElement element : all) {
            allText[i++] = element.getText();
        }

        all.get(all.size() - 1).click();


    }


    @Step("Ucus paketi en pahalı olan secilir")
    public void beRich() {
        List<MobileElement> all = driver.findElements(By.xpath("//*[@resource-id='com.pozitron.pegasus:id/list_item_availability_bundle_text_view_fare' and @enabled='true']"));
        String[] allText = new String[all.size()];
        int i = 0;
        for (MobileElement element : all) {
            allText[i++] = element.getText();
        }

        all.get(all.size() - 1).click();

    }

    @Step("ekonomi business secimi sonrası uyarı mesajı devam et butonuna basılır")
    public void pop2() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue"))).click();
    }

    @Step("ekonomi business secimi sonrası uyarı mesajı devam et butonuna basılır2")
    public void pop3() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue"))).click();
    }

    @Step("Satın alma islemine devam edilir")
    public void contiSepet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.pozitron.pegasus:id/layout_booking_total_amount_button_action"))).click();
    }


    @Step("Sayfa bir bolum asagi kaydirilir.")
    public void miniSwipe() {
        for (int i = 0; i <= 3; i++)
            (new TouchAction(driver))

                    .press(PointOption.point(300, 300))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(300, 300))
                    .release()
                    .perform();
    }

    @Step("Yolcu isim soyisim girilir")
    public void giveNameAndSurname() {
        driver.findElement(By.xpath("//*[@class='android.widget.EditText' and @package='com.pozitron.pegasus' and @enabled='true']")).sendKeys("Caner" + Keys.ENTER + "BASAT");
    }

    @Step("Yolcu dogum tarihi yazdırılır")
    public void sendBirthdate()throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @instance=‘2’]"))).click();
        //yıl
        sendKeysByXpath("//*[@class='android.widget.EditText' and @instance=‘2’]","1996");
        Thread.sleep(1500);
        //gun
        sendKeysByXpath("//*[@class='android.widget.EditText' and @instance=‘1’]","12");
        Thread.sleep(1500);
        //ay
        sendKeysByXpath("//*[@class='android.widget.EditText' and @instance=‘0’]","Nov");
        Thread.sleep(1500);
    }

    public void sendKeysByXpath(String xpath,String text){
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
}


