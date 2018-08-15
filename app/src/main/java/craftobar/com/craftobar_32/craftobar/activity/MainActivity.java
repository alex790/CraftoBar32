package craftobar.com.craftobar_32.craftobar.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.fragments.AboutFragment;
import craftobar.com.craftobar_32.craftobar.fragments.BeerTapsFragment;
import craftobar.com.craftobar_32.craftobar.fragments.CatalogFragment;
import craftobar.com.craftobar_32.craftobar.fragments.EventsFragment;
import craftobar.com.craftobar_32.craftobar.util.BottomNavigationViewHelper;
import craftobar.com.craftobar_32.craftobar.util.StatusBarUtil;


public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.bottom_navigation)
    protected BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        navigationView.setOnNavigationItemSelectedListener(navigationSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigationView);

        StatusBarUtil.updateStatusBarColor(this, R.color.backGroundTaps);
    }


    @Override
    protected void onResume() {
        super.onResume();
        replaceFragment(new BeerTapsFragment(), getString(R.string.title_beer_taps));
    }


    @Override
    public void onBackPressed() {
            super.onBackPressed();
            appManager.exit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.beer_taps:
                    replaceFragment(new BeerTapsFragment(), getString(R.string.title_beer_taps));
                    break;

                case R.id.catalog:
                    replaceFragment(new CatalogFragment(), getString(R.string.title_catalog));
                    break;

                case R.id.events:
                    replaceFragment(new EventsFragment(), getString(R.string.title_events));
                    break;

                case R.id.about:
                    replaceFragment(new AboutFragment(), getString(R.string.title_about));
                    break;

                default:
                    break;
            }

            return true;
        }
    };


    private void replaceFragment(Fragment fragment, String title) {

        toolbar.setTitle(title);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commitAllowingStateLoss();
    }


}
