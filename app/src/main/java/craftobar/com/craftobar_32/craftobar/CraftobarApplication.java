package craftobar.com.craftobar_32.craftobar;

import android.app.Application;
import android.content.Context;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class CraftobarApplication extends Application {

    private AppManager appManager;


    // Этот метод вызывается до onCreate()
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    // Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created.
    @Override
    public void onCreate() {
        super.onCreate();
        appManager = new AppManager(this);
    }


    public AppManager getAppManager() {
        return appManager;
    }
}
