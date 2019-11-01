package com.jtv.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.jtv.actions.android.HomePageActivityAction;
import com.jtv.screen.android.MainActivity;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.*;
import com.jtv.screen.android.HomePageActivity;
public class getStartedTest extends DefaultTest  {

    private AndroidDevice androidDevice;
    private AppiumServer androidServer;
    private MainActivity	main;


    @DataProvider
    public static Iterator <Object []> getOrientation () {
        final List <Object []> data = new ArrayList<Object[]>();
        data.add (new Object [] { ScreenOrientation.LANDSCAPE });
        data.add (new Object [] { ScreenOrientation.PORTRAIT });
        return data.iterator ();
    }

    @Test
    public void testGetStarted(){
        this.main.onElement("Main").click();
        this.main.onElement("GetStarted").click();
    }

    @BeforeMethod
    public void setupMethod () {
        this.androidDevice.startRecording ();
    }


    @Parameters({ "server", "device" })
    @BeforeTest
    public void setupTest (final String server, final String device) {
        this.androidServer = new AppiumServer(server);
        this.androidServer.start ();

        this.androidDevice = new AndroidDevice (this.androidServer, device);
        this.androidDevice.start ();
        this.main = new MainActivity(this.androidDevice);
    }


    @AfterMethod
    public void teardownMethod () {
        this.androidDevice.stopRecording ();
    }

    @AfterTest
    public void tearDownTest () {
        this.androidDevice.stop ();
        this.androidServer.stop ();
    }


}
