package Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
public class BasePage
{
    public RemoteWebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver = (RemoteWebDriver)driver;
    }

    public BasePage() {
    }
}



