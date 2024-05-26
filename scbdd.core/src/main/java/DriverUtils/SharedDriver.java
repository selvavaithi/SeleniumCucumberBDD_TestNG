package DriverUtils;

import Common.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class SharedDriver {

    public SharedDriver(){

        String browser = System.getProperty("browser");

        switch(browser.toLowerCase()){
            case "chrome":{
                if(DriverAgent.getDrivers()==null){
                    WebDriverManager.chromedriver().setup();
                    WebDriver driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ConfigLoader.plsWaitTimeOut));
                    driver.manage().window().maximize();

                    DriverAgent.addDriver(driver);
                    break;
                }
            }
            case "edge":{
                if(DriverAgent.getDrivers()==null){
                    WebDriverManager.edgedriver().setup();
                    WebDriver driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ConfigLoader.plsWaitTimeOut));
                    driver.manage().window().maximize();

                    DriverAgent.addDriver(driver);
                    break;
                }
            }
            default:{
                break;
            }
        }

    }
}
