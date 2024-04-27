package appium2grid4;

import java.io.IOException;

public class Grid {
    public static void main(String[] args) throws IOException, InterruptedException {
        CommonUtils.executePermissionToScripts();
        CommonUtils.runScript("RunGrid.sh");
        CommonUtils.runScript("RunAppium.sh");
//        Thread.sleep(60000);
    }
}
