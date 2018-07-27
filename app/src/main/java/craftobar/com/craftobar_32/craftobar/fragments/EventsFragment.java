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
import craftobar.com.craftobar_32.craftobar.adapters.EventAdapter;
import craftobar.com.craftobar_32.craftobar.models.Event;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class EventsFragment extends BaseFragment {


    public static final String TAG = "EventsFragment_TAG";

    private Unbinder unbinder;

    @BindView(R.id.rv_events)
    RecyclerView recyclerView;

    private EventAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        unbinder = ButterKnife.bind(this, view);

        adapter = new EventAdapter(new ArrayList<Event>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        appManager.setEventsObserver(this, eventsObserver);


    }

    private Observer<List<Event>> eventsObserver = new Observer<List<Event>>() {
        @Override
        public void onChanged(@Nullable final List<Event> events) {
            adapter.setEventList(events);
        }
    };
}
