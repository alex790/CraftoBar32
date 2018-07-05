package craftobar.com.craftobar_32.craftobar;

import android.app.Application;
import android.content.Context;
import craftobar.com.craftobar_32.craftobar.dagger.AppComponent;
import craftobar.com.craftobar_32.craftobar.dagger.AppModule;
import craftobar.com.craftobar_32.craftobar.dagger.DaggerAppComponent;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class App extends Application {

    private static AppComponent component;


    // Этот метод вызывается до onCreate()
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    // Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created.
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public static AppComponent getComponent(){
        return component;
    }

}
