package craftobar.com.craftobar_32.craftobar.dagger;

import javax.inject.Singleton;

import craftobar.com.craftobar_32.craftobar.AppManager;
import craftobar.com.craftobar_32.craftobar.activity.BaseActivity;
import craftobar.com.craftobar_32.craftobar.activity.SplachActivity;
import craftobar.com.craftobar_32.craftobar.fragments.BaseFragment;
import dagger.Component;

/**
 * Created by Home on 03.07.2018.
 */


@Component(modules = {AppModule.class})//, NetworkModule.class})
@Singleton
public interface AppComponent {

    void ingect(SplachActivity activity);
    void ingect(BaseActivity activity);
    void ingect(BaseFragment fragment);

    AppManager getAppManager();
}
