package org.example;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DockerDemoTest {

    @Test
    @Parameters("browser")
    public void dockerTestUsingChromeOrFireFox(String browserName) throws MalformedURLException {
        System.out.println("Hello world!");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browserName.equals("chrome")) {
            System.out.println("Inside chrome");
            WebDriverManager.chromedriver().setup();
            capabilities.setBrowserName("chrome");
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            capabilities.setBrowserName("firefox");
        }
        WebDriver driver1 = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        driver1.manage().window().maximize();
        driver1.get("http://amazon.in");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        WebElement element = driver1.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver1);
        actions.moveToElement(element)
                .click()
                .sendKeys("IPhone 14")
                .sendKeys(Keys.ENTER)
                .build().perform();
//        driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 14");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        driver1.quit();


    }

    @Test
    @Parameters("browser")
    public void dockerTestUsingEdge(String browserName) throws MalformedURLException {
        System.out.println("Hello world!");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browserName.equals("edge")) {
            System.out.println("Inside edge");
            WebDriverManager.edgedriver().setup();
            capabilities.setBrowserName("MicrosoftEdge");
            System.out.println(capabilities.getBrowserName());
        }

        WebDriver driver1 = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        driver1.manage().window().maximize();
        driver1.get("http://amazon.in");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        WebElement element = driver1.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver1);
        actions.moveToElement(element)
                .click()
                .sendKeys("IPhone 14")
                .sendKeys(Keys.ENTER)
                .build().perform();
//        driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 14");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        driver1.quit();


    }

}