package craftobar.com.craftobar_32.craftobar;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import craftobar.com.craftobar_32.craftobar.models.ChildItemModel;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class BeerTapUtil {

    public static List<ParentItemModel> getBeerTapData(String[] parentItemJsonArray) {

        List<ParentItemModel> elements = new ArrayList<>();
        List<ChildItemModel> child = Collections.singletonList(new ChildItemModel("Описалово"));
        Gson gson = new Gson();

        for (String itemJsonString : parentItemJsonArray) {
            ParentItemModel model = gson.fromJson(itemJsonString, ParentItemModel.class);
            model.setChildrenList(child);
            elements.add(model);
        }
        return elements;
    }
}
