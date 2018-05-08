package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminAddTour {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminAddTour() throws Exception {
    driver.findElement(By.linkText("Tours")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Modules')])[2]")).click();
    driver.findElement(By.linkText("Add New")).click();
    driver.findElement(By.name("tourstatus")).click();
    driver.findElement(By.name("tourstatus")).click();
    driver.findElement(By.name("tourname")).click();
    driver.findElement(By.name("tourname")).clear();
    driver.findElement(By.name("tourname")).sendKeys("Testing Tour");
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.findElement(By.xpath("//html")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.name("maxadult")).click();
    driver.findElement(By.name("maxadult")).clear();
    driver.findElement(By.name("maxadult")).sendKeys("10");
    driver.findElement(By.name("adultprice")).click();
    driver.findElement(By.name("adultprice")).clear();
    driver.findElement(By.name("adultprice")).sendKeys("100");
    driver.findElement(By.name("tourdays")).click();
    driver.findElement(By.name("tourdays")).clear();
    driver.findElement(By.name("tourdays")).sendKeys("4");
    driver.findElement(By.name("tournights")).click();
    driver.findElement(By.name("tournights")).clear();
    driver.findElement(By.name("tournights")).sendKeys("4");
    driver.findElement(By.name("tourstars")).click();
    new Select(driver.findElement(By.name("tourstars"))).selectByVisibleText("3");
    driver.findElement(By.name("tourstars")).click();
    driver.findElement(By.id("isfeatured")).click();
    driver.findElement(By.xpath("//div[@id='GENERAL']/div[9]")).click();
    driver.findElement(By.name("deposittype")).click();
    driver.findElement(By.name("deposittype")).click();
    driver.findElement(By.name("taxtype")).click();
    driver.findElement(By.name("taxtype")).click();
    driver.findElement(By.id("add")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
