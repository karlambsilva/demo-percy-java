import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.ToDoPage;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoTest extends BaseTest{
    private ToDoPage toDoPage;

    @BeforeEach
    public void openToDoPage(){
        toDoPage = PageFactory.initElements(driver, ToDoPage.class);
        toDoPage.openPage();
    }

    @Test
    public void loadsHomePage(){

        WebElement container = toDoPage.getContainer();
        assertNotNull(container);

        // Take a Percy snapshot.
        percy.snapshot("Home Page");
    }

    @Test
    public void acceptsANewTodo() {

        // We start with zero todos.
        assertEquals(0, toDoPage.getNumberItemsInTheList());

        // Add a todo in the browser.
        toDoPage.addNewToDo("A new fancy todo!");
        assertEquals(1, toDoPage.getNumberItemsInTheList());

        // Take a Percy snapshot specifying browser widths.
        percy.snapshot("One todo", Arrays.asList(768, 992, 1200));
    }

    @Test
    public void letsYouCheckOffATodo() {

        toDoPage.addNewToDo("A new todo to check off");
        assertEquals(1, toDoPage.getNumberItemsInTheList());

        assertEquals("1 item left", toDoPage.getMsgToDosLeft());
        toDoPage.clickOnToDoCheck();

        assertEquals(1, toDoPage.getNumberItemsInTheList());

        // Take a Percy snapshot specifying a minimum height.
        percy.snapshot("Checked off todo", null, 2000);
    }

    @AfterEach
    public void clearAll(){

    }

}
