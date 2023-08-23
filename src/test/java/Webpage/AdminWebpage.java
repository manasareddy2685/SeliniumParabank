package Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.rmi.Remote;
import java.util.HashMap;
import static Utilities.GenericMethods.elementClick;
import static Utilities.GenericMethods.waitForElementClickable;

public class AdminWebpage extends BasePage {
    RemoteWebDriver driver;

       public AdminWebpage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//a[contains(text(),'Admin Page')]")
    public static WebElement AdminLink;
    @FindBy(xpath="//div[@id='rightPanel']/table/tbody/tr/td/form/table/tbody/tr/td[2]/button")
    public WebElement cleanbutton;
    @FindBy(xpath="//div[2]/p/b")
    public static WebElement databasecleaned;
    @FindBy(xpath="//div[@id='rightPanel']/table/tbody/tr/td/form/table/tbody/tr/td[2]/button")
    public WebElement initializebutton;
    @FindBy(xpath="//div[2]/p/b")
    public static WebElement getDatabaseinitialized;
    @FindBy(xpath = "//input[@id='accessMode1']")
    public WebElement clicksoap;
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@id='rightPanel']/p/b")
    public static WebElement settingsSuccessfully;

    public void FillAdmin(HashMap<String, String> projectDetails) throws InterruptedException {

        elementClick(AdminLink);

        waitForElementClickable(cleanbutton, 5);
        cleanbutton.click();

        waitForElementClickable(initializebutton, 5);
        initializebutton.click();

        waitForElementClickable(clicksoap, 5);
        clicksoap.click();

        waitForElementClickable(submitButton, 5);
        submitButton.click();

        System.out.println("Settings Saved successfully");
    }
}






