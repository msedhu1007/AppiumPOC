package com.jtv.actions.android;
import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.jtv.screen.android.HomePageActivity;

public class HomePageActivityAction extends AndroidActivityActions {

    public HomePageActivityAction(final AndroidDevice device){
        super (device);
    }

    @Override
    public void perform(){
        final HomePageActivity  homepage = new HomePageActivity(getDevice ());
        homepage.onElement("GetStarted").click();
    }

}
