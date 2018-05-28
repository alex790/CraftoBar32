package craftobar.com.craftobar_32.craftobar.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.util.PermissionUtil;


/**
 * Created by a.zverev on 13.12.2017.
 */

public class PermissionActivity extends BaseActivity {

    private static final int REQUEST_APP_PERMISSIONS = 1;

    private TextView tvMessage;
    private Button btExit;
    private Button btSettings;
    private boolean showRequestDialog = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        tvMessage = findViewById(R.id.tv_message);
        btExit = findViewById(R.id.bt_exit);
        btSettings = findViewById(R.id.bt_settings);

        btExit.setOnClickListener(clickExit);
        btSettings.setOnClickListener(clickSettings);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (showRequestDialog) {
            PermissionUtil.requestPermission(this);
        }

        updateUiState();
    }


    private void updateUiState(){

        int visibility = showRequestDialog ? View.GONE : View.VISIBLE;

        btExit.setVisibility(visibility);
        btSettings.setVisibility(visibility);
        tvMessage.setVisibility(visibility);
    }


    private View.OnClickListener clickExit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            appManager.setNeedExit();
            finish();
        }
    };


    private View.OnClickListener clickSettings = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent, REQUEST_APP_PERMISSIONS);
        }
    };


    // решение пользователя по разрешениям
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults != null && grantResults.length > 0) {
            // т.к. у нас только одно разрешение на работу с файловой системой берём первый
            int result = grantResults[0];

            // если пользователь разрешил приложению работу с файловой системой
            if (result == PackageManager.PERMISSION_GRANTED) {
               finish();
            }
            else {
                showRequestDialog = false;
            }
        }
    }



}
