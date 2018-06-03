package craftobar.com.craftobar_32.craftobar.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import craftobar.com.craftobar_32.craftobar.R;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class EventsFragment extends BaseFragment {


    public static final String TAG = "EventsFragment_TAG";

    private Unbinder unbinder;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }



}
