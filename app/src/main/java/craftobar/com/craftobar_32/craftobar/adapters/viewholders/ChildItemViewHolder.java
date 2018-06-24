package craftobar.com.craftobar_32.craftobar.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.models.ChildItemModel;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class ChildItemViewHolder extends ChildViewHolder {


    @BindView(R.id.description)
    TextView description;


    public ChildItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }


    public void bind(ChildItemModel model) {
        description.setText(model.getDescription());
    }
}
