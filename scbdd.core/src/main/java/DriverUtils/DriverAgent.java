package DriverUtils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverAgent {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

    private static List<WebDriver> driverValut = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                driverValut.forEach(WebDriver::quit);
            }
        });
    }

    public DriverAgent() {

    }

    public static WebDriver getDrivers() {
        return drivers.get();
    }

    public static void addDriver(WebDriver dr) {
        driverValut.add(dr);
        drivers.set(dr);
    }

    public static void releaseDriver() {
        WebDriver dr = drivers.get();
        driverValut.remove(drivers.get());
        drivers.remove();
        dr.quit();
    }

}