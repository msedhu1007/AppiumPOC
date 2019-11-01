package com.jtv.tests;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.jtv.screen.android.MainActivity;
import org.testng.annotations.*;

public class DefaultTest {

    protected AndroidDevice androidDevice;
    private AppiumServer androidServer;
    protected MainActivity	main;

    @BeforeMethod
    public void setupMethod () {
        this.androidDevice.startRecording ();
    }


    @Parameters({ "server", "device" })
    @BeforeTest
    public void setupTest (final String server, final String device) {
        this.androidServer = new AppiumServer (server);
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
