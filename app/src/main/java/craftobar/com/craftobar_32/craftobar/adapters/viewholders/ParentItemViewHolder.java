package craftobar.com.craftobar_32.craftobar.adapters.viewholders;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class ParentItemViewHolder extends ParentViewHolder {


    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;


    private ImageView imageView;

    private TextView tvNumber;
    private TextView tvName;
    private TextView tvType;
    private TextView tvMaker;
    private TextView tvPrice;
    private TextView tvVol;



    public ParentItemViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.button);

        tvNumber = itemView.findViewById(R.id.tv_number);
        tvName = itemView.findViewById(R.id.tv_name);
        tvType = itemView.findViewById(R.id.tv_type);
        tvMaker = itemView.findViewById(R.id.tv_maker);
        tvPrice = itemView.findViewById(R.id.tv_price);
        tvVol = itemView.findViewById(R.id.tv_vol);
    }


    public void bind(ParentItemModel model) {
        tvNumber.setText(model.getNumber());
        tvName.setText(model.getName().toUpperCase());
        tvType.setText(model.getType().toUpperCase());
        tvMaker.setText(model.getMaker().toUpperCase());
        tvPrice.setText(model.getPrice());
        tvVol.setText(model.getVol() + "%");
    }


    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);

            if (expanded) {
                imageView.setRotation(ROTATED_POSITION);
            } else {
                imageView.setRotation(INITIAL_POSITION);
            }

    }


    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);

        RotateAnimation rotateAnimation;

        if (expanded) { // rotate clockwise
            rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        }
        else { // rotate counterclockwise
            rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        }

        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);

        imageView.startAnimation(rotateAnimation);
    }


}
