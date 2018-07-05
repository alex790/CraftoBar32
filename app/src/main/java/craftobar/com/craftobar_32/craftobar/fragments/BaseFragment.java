package craftobar.com.craftobar_32.craftobar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import craftobar.com.craftobar_32.craftobar.AppManager;
import craftobar.com.craftobar_32.craftobar.App;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class BaseFragment extends Fragment {

     protected AppManager appManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App application = (App) getActivity().getApplication();
        appManager = application.getAppManager();
    }
}
