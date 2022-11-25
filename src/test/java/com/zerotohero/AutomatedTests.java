package com.zerotohero;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatedTests {

    /**
     * A simple dummy test to check if selenium and testng are
     * working just fine! 😀
     */
    @Test
    public void dummyTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assertTrue(true);
    }
}
