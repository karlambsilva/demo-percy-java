package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoPage extends BasePage{

    private static final String APP_URL = "https://karlambsilva.github.io/demo-percy-java/";

    @FindBy(css = ".todoapp")
    private WebElement container;

    @FindBy(css = ".new-todo")
    private WebElement input;

    @FindBy(css = "input.toggle")
    private WebElement toDoCheck;

    @FindBy(css = ".todo-list li")
    private List<WebElement> items;

    @FindBy(css = ".todo-count")
    private WebElement toDosLeft;

    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    public void addNewToDo(String text){
        input.sendKeys(text);
        input.sendKeys(Keys.RETURN);
    }

    public void clickOnToDoCheck(){
        toDoCheck.click();
    }

    public int getNumberItemsInTheList(){
        return items.size();
    }

    public String getMsgToDosLeft(){
        return toDosLeft.getText();
    }

    public WebElement getContainer() {
        return container;
    }

    public void openPage() {
        super.openPage(APP_URL);
    }
}
