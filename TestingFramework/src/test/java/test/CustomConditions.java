package test;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomConditions {
    public static ExpectedCondition<Boolean> textNotEmpty(String xpath) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath(xpath)).getText().length() != 0;
            }
        };
    }

    public static ExpectedCondition<Boolean> textIsEmpty(String xpath) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath(xpath)).getText().length() == 0;
            }
        };
    }

    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
    }
}
