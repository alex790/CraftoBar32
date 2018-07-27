package craftobar.com.craftobar_32.craftobar.network;

import java.util.List;

import craftobar.com.craftobar_32.craftobar.models.Event;
import craftobar.com.craftobar_32.craftobar.models.Tap;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Home on 21.06.2018.
 */

public interface CraftobarApi {

    @GET("taps")
    Single<List<Tap>> beerTaps();


    @GET("events")
    Single<List<Event>> events();

}
