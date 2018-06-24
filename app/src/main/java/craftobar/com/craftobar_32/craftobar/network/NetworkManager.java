package craftobar.com.craftobar_32.craftobar.network;

import android.util.Log;

import java.util.List;

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

        Log.d("Alex", "createRetrofit ");

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        craftobarApi = retrofit.create(CraftobarApi.class);

        Log.d("Alex", "createRetrofit finish ");

    }



    public void startLoadBeerTaps(DisposableSingleObserver<List<Tap>> observer) {
        Log.d("Alex", "делаем загрузку данных ");

        Single<List<Tap>> messages = craftobarApi.beerTaps();

        messages.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
