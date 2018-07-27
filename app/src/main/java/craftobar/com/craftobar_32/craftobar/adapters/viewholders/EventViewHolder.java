package craftobar.com.craftobar_32.craftobar.adapters.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.models.Event;

public class EventViewHolder extends RecyclerView.ViewHolder {
    private final Context context;
    @BindView(R.id.tv_event_name)
    public TextView tvName;

    @BindView(R.id.tv_info)
    public TextView tvInfo;

    @BindView(R.id.tv_date)
    public TextView tvDate;

    @BindView(R.id.tv_descr)
    public TextView tvDescription;

    @BindView(R.id.iv_Image)
    protected ImageView ivImage;

    public EventViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void bind(Event event) {
        tvName.setText(event.getName());
        tvInfo.setText(event.getInfo());
        tvDate.setText(event.getDateFormat());
        tvDescription.setText(event.getDescription());

        Glide.with(context).load(event.getImageUrl()).into(ivImage);
    }
}