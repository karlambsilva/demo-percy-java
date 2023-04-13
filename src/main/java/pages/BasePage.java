package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openPage(String url){
        this.driver.get(url);
    }

    public WebElement findElement(final By main) {
        waitToBePresent(main);
        return this.driver.findElement(main);
    }

    public void waitToBePresent(final By locatorBy){
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorBy));
    }
}
