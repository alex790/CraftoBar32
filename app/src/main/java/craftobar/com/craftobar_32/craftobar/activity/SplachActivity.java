package craftobar.com.craftobar_32.craftobar.activity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.util.PermissionUtil;


public class SplachActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (appManager.isNeedExit()) {
            finish();
            appManager.exit();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        // если разрешения установлены
        if (PermissionUtil.checkPermission(this)) {
            startSplashTimer();
            appManager.startSplashTime();
        }
        else {
            // иначе переходим на страницу разрешений
            appManager.showPermissionPage();
        }
    }


    @SuppressLint("StaticFieldLeak")
    private void startSplashTimer() {

        // Todo заменить на что-нить поудобнее Rx например

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

//                if (appManager.isNeedExit()) {
//                    appManager.exit();
//                }
//                else {
//                }
                appManager.showMainPage();
                finish();
            }
        }.execute();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        appManager.setNeedExit();
    }
}
