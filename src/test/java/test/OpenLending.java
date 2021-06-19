package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utility.TestBase;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class OpenLending extends TestBase {

    @Test
    public void findingOpenLending() {
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Open Lending" + Keys.ENTER);

        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        WebElement openLendingLink = driver.findElement(By.partialLinkText("LinkedIn"));
        openLendingLink.click();

        driver.findElement(By.xpath("(//button[@class='form-toggle'])[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys( prop.getProperty("email"));
        driver.findElement(By.id("login-password")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.id("login-submit")).click();

        WebElement sloganMessage = driver.findElement(By.xpath("(//p)[1]"));
        String actualMessage = sloganMessage.getText();
        String expectedMessage = "Say YES to more automotive loans.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
