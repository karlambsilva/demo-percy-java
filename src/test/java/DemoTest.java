import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoTest extends BaseTest{
    private static final String APP_URL = "https://pages.git.i.mercedes-benz.com/KARLSIL/demo-percy-java/";

    @BeforeEach
    public void openAppPage(){
        driver.get(APP_URL);
    }

    @Test
    public void loadsHomePage(){

        WebElement element = driver.findElement(By.className("todoapp"));
        assertNotNull(element);

        // Take a Percy snapshot.
        percy.snapshot("Home Page");
    }

    @Test
    public void acceptsANewTodo() {

        // We start with zero todos.
        List<WebElement> todoEls = driver.findElements(By.cssSelector(".todo-list li"));
        assertEquals(0, todoEls.size());

        // Add a todo in the browser.
        WebElement newTodoEl = driver.findElement(By.className("new-todo"));
        newTodoEl.sendKeys("A new fancy todo!");
        newTodoEl.sendKeys(Keys.RETURN);

        // Now we should have 1 todo.
        todoEls = driver.findElements(By.cssSelector(".todo-list li"));
        assertEquals(1, todoEls.size());

        // Take a Percy snapshot specifying browser widths.
        percy.snapshot("One todo", Arrays.asList(768, 992, 1200));
    }

    @Test
    public void letsYouCheckOffATodo() {

        WebElement newTodoEl = driver.findElement(By.className("new-todo"));
        newTodoEl.sendKeys("A new todo to check off");
        newTodoEl.sendKeys(Keys.RETURN);

        WebElement todoCountEl = driver.findElement(By.className("todo-count"));
        assertEquals("1 item left", todoCountEl.getText());

        driver.findElement(By.cssSelector("input.toggle")).click();

        todoCountEl = driver.findElement(By.className("todo-count"));
        assertEquals("0 items left", todoCountEl.getText());

        // Take a Percy snapshot specifying a minimum height.
        percy.snapshot("Checked off todo", null, 2000);
    }

}
