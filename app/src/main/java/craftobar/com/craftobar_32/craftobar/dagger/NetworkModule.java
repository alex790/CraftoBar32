package craftobar.com.craftobar_32.craftobar.dagger;

import javax.inject.Singleton;

import craftobar.com.craftobar_32.craftobar.network.NetworkManager;
import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

/**
 * Created by Home on 03.07.2018.
 */

@Module
public class NetworkModule {

    @Provides
    @NonNull
    @Singleton
    public NetworkManager provideNetworkManager(){
        return new NetworkManager();
    }
}
