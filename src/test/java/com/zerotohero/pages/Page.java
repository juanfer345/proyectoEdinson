package com.zerotohero.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {

    protected WebDriver driver = new ChromeDriver();

    public Page(String url) {
        // Setting the window dimensions and placing it in the left part of the screen
        driver.manage().window().setSize(new Dimension(781, 870));
        driver.manage().window().setPosition(new Point(-6, 0));
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
