package Test;

import org.testng.annotations.*;
import java.net.MalformedURLException;

public class TestBase {
    public String browserType;
    @Parameters("browserType")
    @BeforeTest
    public void Setup(@Optional String browserType) throws MalformedURLException, InterruptedException {
        this.browserType = browserType;

    }

}





