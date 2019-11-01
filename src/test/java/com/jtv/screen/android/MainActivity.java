package com.jtv.screen.android;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MainActivity  extends DefaultActivity {

    public MainActivity (final AndroidDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {

        final DeviceElement main = DeviceElement.create ("Main")
                .waitStrategy (WaitStrategy.VISIBLE)
                .forAndroid (By.id ("android:id/content"));

        return main;

    }

}
