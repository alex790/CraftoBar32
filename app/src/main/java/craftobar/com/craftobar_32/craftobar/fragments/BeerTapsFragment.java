package craftobar.com.craftobar_32.craftobar.fragments;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.adapters.ExpandableBeerTapsAdapter;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class BeerTapsFragment extends BaseFragment {

    public static final String TAG = "BeerTapsFragment_TAG";

    private Unbinder unbinder;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private ExpandableBeerTapsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beer_taps, container, false);
        unbinder = ButterKnife.bind(this, view);

        adapter = new ExpandableBeerTapsAdapter(new ArrayList<ParentItemModel>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        appManager.setBeerTapsObserver(this, beeerTapsObserver);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private Observer<List<ParentItemModel>> beeerTapsObserver = new Observer<List<ParentItemModel>>() {
        @Override
        public void onChanged(@Nullable final List<ParentItemModel> parentItemModels) {
            adapter.setParentList(parentItemModels, false);
        }
    };





}
