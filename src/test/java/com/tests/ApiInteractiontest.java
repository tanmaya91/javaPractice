package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @author tasahu
 */
public class ApiInteractiontest {

    @Test
    public void test54() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), requestPaused ->
                {
                    if(requestPaused.getRequest().getUrl().contains("ui-config-srcsystem")) {
                        /*String mockedUrl = requestPaused.getRequest().getUrl().replace("2022-02-S-Release_qa_ready", "test");
                        System.out.println(mockedUrl);
                        devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(mockedUrl), Optional.of(requestPaused.getRequest().getMethod()),
                                Optional.empty(), Optional.empty()));*/
                        devTools.send(Fetch.fulfillRequest(requestPaused.getRequestId(), 400, Optional.empty(), Optional.empty(), Optional.empty(),
                                Optional.empty()));
                    }
                    else
                    {
                        devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

                    }
                }
                );

        driver.get("https://qa-ma.mrel.infaqa.com/identity-service/home");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@id='username']/input")).sendKeys("alliedjan06");
        driver.findElement(By.xpath("//div[@id='password']/input")).sendKeys("Password@1");
        driver.findElement(By.xpath("//span[contains(text(), 'Log In')]")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//span[contains(text(), 'Business 360 Console')]")).click();

    }

    public boolean waitForElementToBeClickable(WebDriver driver, WebElement ele) {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            return true;

    }

}
