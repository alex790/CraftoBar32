package craftobar.com.craftobar_32.craftobar.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import craftobar.com.craftobar_32.craftobar.R;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class CatalogFragment extends BaseFragment {


    public static final String TAG = "CatalogFragment_TAG";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalog, container, false);

        return view;
    }


}
