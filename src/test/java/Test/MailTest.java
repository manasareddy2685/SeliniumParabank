package Test;
import Webpage.AdminWebpage;
import Webpage.Mail;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import static Utilities.GenericMethods.*;
import static Utilities.ReadExcelFile.readExcel;
public class MailTest extends TestBase{
    public static RemoteWebDriver driver;

    @DataProvider(name="test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\test\\resources", "Mail.xlsx", "Sheet1");
        return hashMapObj;
    }
    @Test(dataProvider="test-data",groups ="smoke",priority=2)
    public void GridType(HashMap<String, String> projectDetails) throws MalformedURLException, InterruptedException {
        if (browserType.equalsIgnoreCase("EDGE")) {
            System.setProperty("web-driver.gecko.driver", "C:\\Temp\\samplemavonproj\\SeliniumParabank\\src\\test\\resources\\drivers\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL("http://192.168.29.43:4444"), options);
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            Thread.sleep(2000);
            Mail newMail = new Mail(driver);
            waitForSearchResults();
            waitForElementClickable(newMail.MailLink, 5);
            newMail.MailLink.click();
            Assert.assertTrue(newMail.customerCare.isDisplayed());
            newMail.FillParaBankMail(projectDetails);
            System.out.println("Mail Created is successful");
            Assert.assertTrue(newMail.SuccessHeader.isDisplayed());
            System.out.println("Selenium Ui launched on edge ");
            System.out.println("the thread of Id for edge is " + Thread.currentThread().getId());
            Thread.sleep(2000);
            driver.close();
        }
         else if (browserType.equalsIgnoreCase("FIREFOX")) {
            System.setProperty("web-driver.gecko.driver","C:\\Temp\\samplemavonproj\\SeleniumParabank\\src\\test\\resources\\drivers\\geckodriver.exe");
            FirefoxOptions options=new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            options.setAcceptInsecureCerts(true);
            options.setCapability("platformName", "windows");
            options.setCapability("se:name", "My sample test");
            driver = new RemoteWebDriver(new URL("http://192.168.29.43:4444"), options);
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            driver.manage().window().maximize();
            AdminWebpage NewAdmin = new AdminWebpage(driver);
            waitForSearchResults();
            waitForElementClickable(NewAdmin.AdminLink, 10);
            NewAdmin.AdminLink.click();
            waitForElementClickable(NewAdmin.cleanbutton,5);
            NewAdmin.cleanbutton.click();
            Assert.assertTrue(AdminWebpage.databasecleaned.isDisplayed());
            NewAdmin.FillAdmin(projectDetails);
            Assert.assertTrue(AdminWebpage.getDatabaseinitialized.isDisplayed());
            NewAdmin.FillAdmin(projectDetails);
            System.out.println("Mail Created is successful");
            Assert.assertTrue(AdminWebpage.settingsSuccessfully.isDisplayed());
            System.out.println("Selenium Ui launched on Firefox ");
            System.out.println("the thread of Id for Firefox is " + Thread.currentThread().getId());
            Thread.sleep(2000);
            driver.close();
            }

            }
              }

