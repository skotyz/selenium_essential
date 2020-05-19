import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Sofia/Documents/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        FormPage.submitForm(driver);

        ConfirmationPage confirmationsPage = new ConfirmationPage();
        confirmationsPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirmationsPage.getAlertBannerText(driver));

        driver.quit();
    }

}
