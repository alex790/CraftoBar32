package craftobar.com.craftobar_32.craftobar.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import craftobar.com.craftobar_32.craftobar.models.Event;
import craftobar.com.craftobar_32.craftobar.models.Tap;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a.zverev on 24.06.2018.
 */

public class NetworkManager {


    private String  baseUrl = "http://api.craftoshop.ru/v1/";

    private Retrofit retrofit;
    private CraftobarApi craftobarApi;


    public NetworkManager() {
        createRetrofit(baseUrl);
    }


    private void createRetrofit(String url) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        craftobarApi = retrofit.create(CraftobarApi.class);
    }


    public void loadBeerTaps(DisposableSingleObserver<List<Tap>> observer) {

        Single<List<Tap>> messages = craftobarApi.beerTaps();

        messages.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public void loadEvents(DisposableSingleObserver<List<Event>> observer) {

        Single<List<Event>> messages = craftobarApi.events();

        messages.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
