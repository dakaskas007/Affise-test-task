package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.GlobalHooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    public static void takeScreenShot() throws IOException {

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";
        File screenshot = ((TakesScreenshot) GlobalHooks.getDriverInstance()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/Screenshots/" + fileName));
    }
}