package com.score.base;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Helpers {

    public Helpers(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }
    static WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

    public static WebElement waitForEl(By byLocator){
       return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public static WebElement getEl(By byLocator){
        return AppDriver.getCurrentDriver().findElement(byLocator);
    }

    public static List<WebElement> getEls(By byLocator){
        return AppDriver.getCurrentDriver().findElements(byLocator);
    }

    public static void click(By byLocator){
        getEl(byLocator).click();
    }

    public static void type(By byLocator, String text){
        getEl(byLocator).sendKeys(text);
    }
    
    public static boolean isVisible(By byLocator){
       return getEl(byLocator).isDisplayed();
    }

    public static void waitNtype(By byLocator, String text){
        waitForEl(byLocator);
        getEl(byLocator).clear();
                getEl(byLocator).sendKeys(text);
    }

    public static void waitNclick(By byLocator){
        waitForEl(byLocator).click();
    }

    public static int size(By byLocator){
        return getEls(byLocator).size();
    }

    public static int size(List<WebElement> els){
        return els.size();
    }

    public static String getText(By byLocator){
        String str = "";
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            str = getEl(byLocator).getText();
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            str =  getAttribute(byLocator, "value");
        }
        return str;
    }

    public static String getAttribute(By byLocator, String attr){
        return waitForEl(byLocator).getAttribute(attr);
    }

    public static boolean isListItemsContain(List<WebElement> items, String text){
        boolean flag = false;

        for(WebElement el: items){
            if(el.getText().contains(text)){
                flag= true;
                break;
            }
        }
        return flag;
    }

    public static boolean isTextMatches(WebElement el, String text){
        return el.getText().equalsIgnoreCase(text);
    }
    public static boolean isTextContains(WebElement el, String text){
        return el.getText().contains(text);
    }

    public static Set<String> getContexts(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContextHandles();
    }

    public static String getCurrentContext(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContext();
    }

    public static Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.getCurrentDriver().findElement(byLocator));
    }
    public static Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public static void selectDropDownByOption(WebElement el, String option){
        getDropDownElement(el).selectByVisibleText(option);
    }

    public static List<WebElement> getDropDownOptions(WebElement el) {
        return getDropDownElement(el).getOptions();
    }

    public static List<WebElement> getDropDownAllSelectedOptions(WebElement el) {
        return getDropDownElement(el).getAllSelectedOptions();
    }

    public static WebElement getDropDownSelectedOption(WebElement el) {
        return getDropDownElement(el).getFirstSelectedOption();
    }

    public static boolean isDropDownItemscontain(WebElement element, String text){
        boolean flag = false;
        List<WebElement> els = getDropDownElement(element).getOptions();
        for(WebElement el: els){
            if(el.getText().contains(text)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
