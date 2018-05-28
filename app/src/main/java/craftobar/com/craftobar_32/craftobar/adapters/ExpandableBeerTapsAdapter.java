package craftobar.com.craftobar_32.craftobar.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import java.util.List;
import craftobar.com.craftobar_32.craftobar.R;
import craftobar.com.craftobar_32.craftobar.models.ChaildItemModel;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;
import craftobar.com.craftobar_32.craftobar.adapters.viewholders.ChildItemViewHolder;
import craftobar.com.craftobar_32.craftobar.adapters.viewholders.ParentItemViewHolder;


/**
 * Created by a.zverev on 22.05.2018.
 */


public class ExpandableBeerTapsAdapter extends ExpandableRecyclerAdapter<ParentItemModel, ChaildItemModel, ParentItemViewHolder, ChildItemViewHolder> {



    public ExpandableBeerTapsAdapter(@NonNull List<ParentItemModel> parentList) {
        super(parentList);
    }


    @NonNull
    @Override
    public ParentItemViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parentViewGroup.getContext());
        View view = inflater.inflate(R.layout.item_parent, parentViewGroup, false);
        return new ParentItemViewHolder(view);
    }

    @NonNull
    @Override
    public ChildItemViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(childViewGroup.getContext());
        View view = inflater.inflate(R.layout.item_child, childViewGroup, false);
        return new ChildItemViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(@NonNull ParentItemViewHolder parentViewHolder, int parentPosition, @NonNull ParentItemModel parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull ChildItemViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull ChaildItemModel child) {
        childViewHolder.bind(child);
    }


    @Override
    public void setParentList(@NonNull List<ParentItemModel> parentList, boolean preserveExpansionState) {
        super.setParentList(parentList, preserveExpansionState);
    }

}
