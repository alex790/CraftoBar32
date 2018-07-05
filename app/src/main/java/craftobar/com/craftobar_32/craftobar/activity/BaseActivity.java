package craftobar.com.craftobar_32.craftobar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import craftobar.com.craftobar_32.craftobar.AppManager;
import craftobar.com.craftobar_32.craftobar.App;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class BaseActivity extends AppCompatActivity {


    @Inject
    protected AppManager appManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().ingect(this);
    }
}
