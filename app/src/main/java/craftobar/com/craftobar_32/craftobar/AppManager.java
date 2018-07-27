package craftobar.com.craftobar_32.craftobar;

import android.app.ActivityManager;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import craftobar.com.craftobar_32.craftobar.activity.MainActivity;
import craftobar.com.craftobar_32.craftobar.activity.PermissionActivity;
import craftobar.com.craftobar_32.craftobar.models.Event;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;
import craftobar.com.craftobar_32.craftobar.models.Tap;
import craftobar.com.craftobar_32.craftobar.network.NetworkManager;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * класс управляющий логикой работы приложения
 *
 * Created by a.zverev on 25.05.2018.
 */

public class AppManager {


    private final Context context;
    private NetworkManager networkManager;
    private MutableLiveData<List<ParentItemModel>> liveDataBeerTaps = new MutableLiveData<>();
    private MutableLiveData<List<Event>> liveDataEvents = new MutableLiveData<>();
    private boolean isNeedExit;



    public AppManager(Context context) {
        this.context = context;
        networkManager = new NetworkManager();
    }


    public void showPermissionPage() {
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public void showMainPage() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public void setBeerTapsObserver (@NonNull LifecycleOwner lifecycleOwner, Observer<List<ParentItemModel>> observer) {
        liveDataBeerTaps.observe(lifecycleOwner, observer);
    }


    public void setEventsObserver (@NonNull LifecycleOwner lifecycleOwner, Observer<List<Event>> observer) {
        liveDataEvents.observe(lifecycleOwner, observer);
    }


    /**
     * Стартовал сплеш скриин
     */
    public void startSplashScreen() {
        networkManager.startLoadBeerTaps(loadTapsObserver);
        networkManager.startLoadEvents(loadEventsObserver);
    }


    private DisposableSingleObserver<List<Tap>> loadTapsObserver = new DisposableSingleObserver<List<Tap>>() {
        @Override
        public void onSuccess(List<Tap> beerTaps) {
            Log.d("Alex", "response tap " + beerTaps.size());
            liveDataBeerTaps.setValue(BeerTapUtil.getBeerTapData(beerTaps));
        }

        @Override
        public void onError(Throwable e) {
            Log.d("Alex", "onError");
        }
    };


    private DisposableSingleObserver<List<Event>> loadEventsObserver = new DisposableSingleObserver<List<Event>>() {
        @Override
        public void onSuccess(List<Event> events) {
            Log.d("Alex", "response events " + events.size());
            liveDataEvents.setValue(events);
        }

        @Override
        public void onError(Throwable e) {
            Log.d("Alex", "onError");
        }
    };


    public void setNeedExit() {
        isNeedExit = true;
    }


    public boolean isNeedExit() {
        return isNeedExit;
    }


    public void exit() {

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            List<ActivityManager.AppTask> listTasks = activityManager.getAppTasks();

            for (ActivityManager.AppTask task : listTasks) {
                task.finishAndRemoveTask();
            }
        }

        System.exit(0);
    }
}
