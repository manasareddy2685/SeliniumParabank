package Webpage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import static Utilities.GenericMethods.*;
public class Mail extends BasePage{

     RemoteWebDriver driver;
       public Mail(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }
        @FindBy(xpath="//a[contains(text(),'contact')]")
        public WebElement MailLink;
       @FindBy(xpath="//div[@id='rightPanel']/h1")
       public WebElement customerCare;
       @FindBy(xpath = "//input[@id='name']")
       public WebElement Name;
       @FindBy(xpath = "//input[@id='email']")
       public WebElement Email;
       @FindBy(xpath = "//input[@id='phone']")
       public WebElement phone;
       @FindBy(xpath = "//textarea[@id='message']")
       public WebElement Message;
       @FindBy(xpath = "//input[@value='Send to Customer Care']")
       public WebElement Button;
       @FindBy(xpath="//div[@id='rightPanel']")
       public WebElement SuccessHeader;

      public void FillParaBankMail(HashMap<String, String> projectDetails)
            throws InterruptedException {

        elementClick(MailLink);

        waitForElementClickable(Name, 5);
        clickAndEnterText(Name, projectDetails.get("Name"));

        waitForElementClickable(Email, 5);
        clickAndEnterText(Email, projectDetails.get("Email"));

        waitForElementClickable(phone, 5);
        clickAndEnterText(phone, projectDetails.get("Phone"));

        waitForElementClickable(Message, 5);
        clickAndEnterText(Message,projectDetails.get("Message"));

        waitForElementClickable(Button, 5);
        Button.click();

        System.out.println("new Mail Created successfully");
    }
}



