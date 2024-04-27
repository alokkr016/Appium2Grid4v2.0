package appium2grid4;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        CommonUtils.runScript("RunGrid.sh");
        CommonUtils.runScript("RunAppium.sh");

        IOSDriver iosDriver = null;
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15 Pro");
        options.setPlatformName("iOS");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/UIKitCatalog.app");
        options.setPlatformVersion("17.4");
        options.setUdid("8CCBB297-D010-430B-963B-A25B60049C26");
        options.setWdaLocalPort(8506);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        iosDriver = new IOSDriver(new URI("http://10.106.27.66:4444/").toURL(), options);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        iosDriver.close();

    }
}
