package craftobar.com.craftobar_32.craftobar.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class ParentItemModel implements Parent<ChildItemModel> {

    private List<ChildItemModel> childrenList;

    private String number;
    private String name;
    private String type;
    private String maker;
    private String price;
    private String vol;


    public ParentItemModel(Tap tap) {
        number = tap.getTapNumber();
        name = tap.getBeer().getName();
        type = tap.getBeer().getType();
        maker = tap.getBeer().getManufacturer();
        price = "";
        vol = tap.getBeer().getAlcohol();

        createChildrenList(tap);
    }


    private void createChildrenList(Tap tap) {

        ChildItemModel childItem = new ChildItemModel();
        childItem.setDescription(tap.getBeer().getDescription());

        childrenList = Collections.singletonList(childItem);
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMaker() {
        return maker;
    }

    public String getPrice() {
        return price;
    }

    public String getVol() {
        return vol;
    }


    @Override
    public List<ChildItemModel> getChildList() {
        return childrenList;
    }


    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

}
