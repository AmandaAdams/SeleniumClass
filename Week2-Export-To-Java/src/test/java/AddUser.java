package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUser1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddUser1() throws Exception {
    driver.get(baseUrl + "/credential-store/domain/_/");
    driver.findElement(By.linkText("Credentials")).click();
    driver.findElement(By.cssSelector("b")).click();
    driver.findElement(By.linkText("Global credentials")).click();
    driver.findElement(By.linkText("Add Credentials")).click();
    new Select(driver.findElement(By.name("_.scope"))).selectByVisibleText("Global");
    new Select(driver.findElement(By.cssSelector("select.setting-input.dropdownList"))).selectByVisibleText("SSH Username with private key");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    new Select(driver.findElement(By.cssSelector("select.setting-input.dropdownList"))).selectByVisibleText("Username with password");
    driver.findElement(By.name("_.username")).clear();
    driver.findElement(By.name("_.username")).sendKeys("test3");
    driver.findElement(By.name("_.password")).clear();
    driver.findElement(By.name("_.password")).sendKeys("password");
    driver.findElement(By.id("yui-gen1-button")).click();
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
