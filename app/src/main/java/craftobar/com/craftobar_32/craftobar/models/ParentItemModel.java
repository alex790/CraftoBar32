package craftobar.com.craftobar_32.craftobar.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.List;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class ParentItemModel implements Parent<ChaildItemModel> {


    private List<ChaildItemModel> childrenList;

    private String number;
    private String name;
    private String type;
    private String maker;
    private String price;
    private String vol;


    public ParentItemModel(List<ChaildItemModel> childrenList) {
        this.childrenList = childrenList;
    }


    public void setChildrenList(List<ChaildItemModel> childrenList) {
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


    public List<ChaildItemModel> getChildrenList() {
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
    public List<ChaildItemModel> getChildList() {
        return childrenList;
    }


    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
