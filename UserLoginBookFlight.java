package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserLoginBookFlight {
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
  public void testUserLoginBookFlight() throws Exception {
    driver.get("https://www.phptravels.net/login");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("demouser");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Flights")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("//span[@id='departure-link-8f340835-d873-4ed3-b574-6efab33b5c35']/span/span/span")).click();
    driver.findElement(By.id("airport")).click();
    driver.findElement(By.id("airport")).clear();
    driver.findElement(By.id("airport")).sendKeys("BWI");
    driver.findElement(By.xpath("//li[@id='typeahead-137-4844-option-0']/a/span[2]")).click();
    driver.findElement(By.id("airport")).clear();
    driver.findElement(By.id("airport")).sendKeys("MKE");
    driver.findElement(By.xpath("//li[@id='typeahead-185-4166-option-0']/a/span[2]")).click();
    driver.findElement(By.xpath("//tr[2]/td[4]/button")).click();
    driver.findElement(By.xpath("//button[2]/span")).click();
    driver.findElement(By.xpath("//button/span/span")).click();
    driver.findElement(By.id("search-for-flights-button")).click();
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
