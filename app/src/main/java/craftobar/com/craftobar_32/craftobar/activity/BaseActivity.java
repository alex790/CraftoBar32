package craftobar.com.craftobar_32.craftobar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import craftobar.com.craftobar_32.craftobar.AppManager;
import craftobar.com.craftobar_32.craftobar.CraftobarApplication;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class BaseActivity extends AppCompatActivity {


    protected AppManager appManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CraftobarApplication application = (CraftobarApplication) getApplication();
        appManager = application.getAppManager();
    }
}
