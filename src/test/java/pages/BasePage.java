package page;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v145.indexeddb.model.Key;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElement(String elementLocater){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementLocater)));

    }
    public void waitForElementByXpath(String elementLocater){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocater)));

    }

    public WebElement waitForElementByCSS(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }
    public void clickButtonXpath(String buttonXpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath))).click();
    }
    public void clickButtonById(String buttonId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonId)));

        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void fillTheBlanks(String elemetLocater,String field){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id(elemetLocater)).sendKeys(field);
    }
    /*public void fillTheBlanksBYCSS(String cssSelector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("""
        arguments[0].focus();
        arguments[0].value = arguments[1];
        arguments[0].dispatchEvent(new Event('input', { bubbles: true }));
        arguments[0].dispatchEvent(new Event('change', { bubbles: true }));
    """, element, text);
    }*/
    public void fillTheBlanksBYCSS(String cssSelector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String currentText = "";

        for (char ch : text.toCharArray()) {
            currentText += ch;

            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))
            );

            js.executeScript("""
            arguments[0].focus();
            arguments[0].value = arguments[1];
            arguments[0].dispatchEvent(new Event('input', { bubbles: true }));
        """, element, currentText);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        WebElement finalElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))
        );

        js.executeScript("""
        arguments[0].dispatchEvent(new Event('change', { bubbles: true }));
    """, finalElement);
    }
    public void clickKeyboardButton(String cssSelector, Keys key){
        driver.findElement(By.cssSelector(cssSelector))
                .sendKeys(key);
    }


}
