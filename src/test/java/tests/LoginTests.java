package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.MainPage;

import java.time.Duration;

public class LoginTests {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeEach
    public void setup(){
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     mainPage= new MainPage(driver);
     loginPage=new LoginPage(driver);
     driver.get("https://www.hepsiburada.com");
    }

    @Test
    public void hepsiBuradaLoginTest() {

        mainPage.waitForElementByXpath(mainPage.myAccount);
        mainPage.clickButtonXpath(mainPage.myAccount);
       // driver.findElement(By.xpath("//span[contains(text(),'Giriş Yap')]")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(mainPage.loginButton)
                )
        );

        wait.until(ExpectedConditions.visibilityOf(loginBtn));

        loginBtn.click();

        //driver.findElement(By.id("login")).click();

        loginPage.waitForElement(loginPage.emailAdress);
        loginPage.fillTheBlanks(loginPage.emailAdress,"SeleniumAut@gmail.com");

        loginPage.waitForElement(loginPage.password);
        loginPage.fillTheBlanks(loginPage.password,"123456");
        //driver.findElement(By.id("txtUserName")).sendKeys("SeleniumAut@gmail.com");

        loginPage.waitForElement(loginPage.loginButton);
        loginPage.clickButtonById(loginPage.loginButton);

        //driver.findElement(By.id("btnLogin")).click();


    }
    @Test
    public void productSearchTest() throws InterruptedException {
        mainPage.waitForElementByCSS(mainPage.productSearch);
        mainPage.fillTheBlanksBYCSS(mainPage.productSearch, "zorba");
        mainPage.waitForElementByCSS(mainPage.productSearch);
        mainPage.clickKeyboardButton(mainPage.productSearch, Keys.ENTER);

    }
    @AfterEach
    public void tearDown(){
        driver.close();
    }
}