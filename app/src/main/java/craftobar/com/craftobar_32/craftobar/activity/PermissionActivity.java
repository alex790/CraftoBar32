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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.util.PermissionUtil;


/**
 * Created by a.zverev on 13.12.2017.
 */

public class PermissionActivity extends BaseActivity {


    private static final int REQUEST_APP_PERMISSIONS = 1;

    @BindView(R.id.tv_message)
    protected TextView tvMessage;

    @BindView(R.id.bt_exit)
    protected Button btExit;

    @BindView(R.id.bt_settings)
    protected Button btSettings;

    private boolean showRequestDialog = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        ButterKnife.bind(this);

        btSettings = findViewById(R.id.bt_settings);
    }


    @Override
    protected void onResume() {
        super.onResume();

        boolean permissionGranted = PermissionUtil.checkPermission(this);

        if (!permissionGranted && showRequestDialog) {
            PermissionUtil.requestPermission(this);
        }

        if (permissionGranted) {
            finish();
        }

        updateUiState();
    }


    private void updateUiState(){

        int visibility = showRequestDialog ? View.GONE : View.VISIBLE;

        btExit.setVisibility(visibility);
        btSettings.setVisibility(visibility);
        tvMessage.setVisibility(visibility);
    }


    @OnClick(R.id.bt_exit)
    public void onClickExit(View v) {
        appManager.setNeedExit();
        finish();
    }


    @OnClick(R.id.bt_settings)
    public void onClickSettings(View v) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent, REQUEST_APP_PERMISSIONS);
    }


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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
