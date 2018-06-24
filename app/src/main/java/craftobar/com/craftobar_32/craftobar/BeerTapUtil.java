package craftobar.com.craftobar_32.craftobar;


import java.util.ArrayList;
import java.util.List;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;
import craftobar.com.craftobar_32.craftobar.models.Tap;


/**
 * Created by a.zverev on 25.05.2018.
 */
public class BeerTapUtil {


    public static List<ParentItemModel> getBeerTapData(List<Tap> beerTaps) {
        List<ParentItemModel> elements = new ArrayList<>();

        for (Tap tap : beerTaps) {
            ParentItemModel parentModel = new ParentItemModel(tap);
            elements.add(parentModel);
        }
        return elements;
    }
}
