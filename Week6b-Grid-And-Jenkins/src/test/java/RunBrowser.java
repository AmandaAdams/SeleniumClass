import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

public class RunBrowser {
    WebDriver driver;
    //String workingDir = "C:\\Users\\cdorsey\\Documents\\workspace\\seleniumclass\\Week6b-Grid-And-Jenkins\\drivers\\";
    String workingDir = System.getProperty("user.dir");

    public RunBrowser(String driverType, boolean runToGrid) {
        DesiredCapabilities desiredCapabilities = null;

        if (driverType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", workingDir + "\\drivers\\IEDriverServer.exe");
            //System.setProperty("webdriver.ie.driver", workingDir + "IEDriverServer.exe");
            //Disable Internet Explorer security errors for IE 9-10
            desiredCapabilities = DesiredCapabilities.internetExplorer();
            desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            if (!runToGrid) {
                driver = new InternetExplorerDriver(desiredCapabilities);
            }
        } else if (driverType.equalsIgnoreCase("Chrome")) {
            if (!runToGrid) {
                System.setProperty("webdriver.chrome.driver", workingDir + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                desiredCapabilities = DesiredCapabilities.chrome();
            }
        } else {
            if (!runToGrid) {
                driver = new FirefoxDriver();
            } else {
                desiredCapabilities = DesiredCapabilities.firefox();
            }
        }
        if(runToGrid) {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);

            } catch (MalformedURLException e) {
                fail("Error building URL to Hub");
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
