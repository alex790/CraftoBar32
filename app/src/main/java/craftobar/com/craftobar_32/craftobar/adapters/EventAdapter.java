package craftobar.com.craftobar_32.craftobar.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.adapters.viewholders.EventViewHolder;
import craftobar.com.craftobar_32.craftobar.models.Event;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> events;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }


    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    public void setEventList(List<Event> eventList) {
        this.events = eventList;
    }
}
