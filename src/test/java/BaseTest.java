import io.percy.selenium.Percy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected static WebDriver driver;
    protected static Percy percy;

    @BeforeEach
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setHeadless(true);

        driver = new ChromeDriver(options);
        percy = new Percy(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
