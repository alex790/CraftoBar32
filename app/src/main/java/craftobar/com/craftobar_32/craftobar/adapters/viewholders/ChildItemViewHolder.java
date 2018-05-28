package craftobar.com.craftobar_32.craftobar.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.models.ChaildItemModel;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class ChildItemViewHolder extends ChildViewHolder {

    private TextView option1;


    public ChildItemViewHolder(View itemView) {
        super(itemView);
        option1 = itemView.findViewById(R.id.option1);
    }


    public void bind(ChaildItemModel model) {
        option1.setText(model.getOption1());
    }
}
