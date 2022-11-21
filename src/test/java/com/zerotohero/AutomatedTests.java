package com.zerotohero;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomatedTests {

    /**
     * A simple dummy test to check if selenium and testng are
     * working just fine! 😀
     */
    @Test
    public void dummyTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Assert.assertTrue(true);
    }
}
