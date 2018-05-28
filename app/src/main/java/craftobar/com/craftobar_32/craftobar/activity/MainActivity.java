package craftobar.com.craftobar_32.craftobar.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.fragments.AboutFragment;
import craftobar.com.craftobar_32.craftobar.fragments.BeerTapsFragment;
import craftobar.com.craftobar_32.craftobar.fragments.CatalogFragment;
import craftobar.com.craftobar_32.craftobar.fragments.EventsFragment;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        replaceFragment(new BeerTapsFragment(), getString(R.string.title_beer_taps));
    }


    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

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

        drawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.closeDrawer(GravityCompat.START);
            }
        }, 100);

        return true;
    }



    private void replaceFragment(Fragment fragment, String title) {

        toolbar.setTitle(title);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commitAllowingStateLoss();
    }


}
