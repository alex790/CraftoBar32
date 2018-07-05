package craftobar.com.craftobar_32.craftobar.dagger;

import android.content.Context;
import javax.inject.Singleton;

import craftobar.com.craftobar_32.craftobar.AppManager;
import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

/**
 * Created by Home on 03.07.2018.
 */

@Module
public class AppModule {

    private Context appContext;

    public AppModule(@NonNull Context context) {
        appContext = context;
    }


    @Provides
    @Singleton
    public Context provideAppContext(){
        return appContext;
    }


    @Provides
    @Singleton
    public AppManager provideAppManager() {
        return new AppManager(appContext);
    }
}
