package craftobar.com.craftobar_32.craftobar;

import android.app.ActivityManager;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.util.List;

import craftobar.com.craftobar_32.craftobar.activity.MainActivity;
import craftobar.com.craftobar_32.craftobar.activity.PermissionActivity;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;
import craftobar.com.craftobar_32.craftobar.util.CbThreadPoolExecuror;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class AppManager {

    private final Context context;
    private CbThreadPoolExecuror execuror;
    private MutableLiveData<List<ParentItemModel>> liveDataBeerTaps = new MutableLiveData<>();
    private boolean isNeedExit;



    public AppManager(Context context) {
        this.context = context;

        execuror = new CbThreadPoolExecuror();

        liveDataBeerTaps.setValue(BeerTapUtil.getBeerTapData());
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


    public void setNeedExit() {
        isNeedExit = true;
    }


    public boolean isNeedExit() {
        return isNeedExit;
    }


    public void exit() {

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            List<ActivityManager.AppTask> listTasks = listTasks = activityManager.getAppTasks();

            for (ActivityManager.AppTask task : listTasks) {
                task.finishAndRemoveTask();
            }
        }

        System.exit(0);
    }


    /**
     * Стартовал сплеш скриин
     */
    public void startSplashTime() {
        // TODO: 28.05.2018 старовал сплеш скрин делаем загрузку данных

    }
}
