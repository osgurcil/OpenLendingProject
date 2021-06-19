package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected Properties prop;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         prop = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/wefix/IdeaProjects/OpenLendingProject/src/test/java/config/configuration.properties");
            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
