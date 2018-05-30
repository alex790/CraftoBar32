package craftobar.com.craftobar_32.craftobar.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import org.json.JSONException;
import org.json.JSONObject;

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


    public ParentItemModel(List<ChildItemModel> childrenList) {
        this.childrenList = childrenList;
    }


    public void setChildrenList(List<ChildItemModel> childrenList) {
        this.childrenList = childrenList;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setMaker(String maker) {
        this.maker = maker;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public void setVol(String vol) {
        this.vol = vol;
    }


    public List<ChildItemModel> getChildrenList() {
        return childrenList;
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


    public String toJSON(){

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("number", getNumber());
            jsonObject.put("name", getName());
            jsonObject.put("type", getType());
            jsonObject.put("maker", getMaker());
            jsonObject.put("price", getPrice());
            jsonObject.put("vol", getVol());

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }

    }
}
