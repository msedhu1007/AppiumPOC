package com.jtv.screen.android;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class HomePageActivity extends DefaultActivity {

    public HomePageActivity(final AndroidDevice device){
        super(device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement main = super.prepare ();

        DeviceElement.create ("frame")
                .waitStrategy (WaitStrategy.VISIBLE)
                .parent (main)
                .forAndroid (By.xpath ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ImageView[1]"));

        DeviceElement.create ("GetStarted")
                .waitStrategy (WaitStrategy.VISIBLE)
                .forAndroid (MobileBy.id ("com.jtv.staging:id/btnActionTutorial"));

        return main;

    }
}
