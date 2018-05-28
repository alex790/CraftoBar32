package craftobar.com.craftobar_32.craftobar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import craftobar.com.craftobar_32.craftobar.models.ChaildItemModel;
import craftobar.com.craftobar_32.craftobar.models.ParentItemModel;

/**
 * Created by a.zverev on 25.05.2018.
 */

public class BeerTapUtil {

    public static List<ParentItemModel> getBeerTapData() {

        List<ParentItemModel> elements = new ArrayList<>();
        List<ChaildItemModel> child = Collections.singletonList(new ChaildItemModel("Описалово"));

        ParentItemModel model1 = new ParentItemModel(child);
        model1.setNumber("1");
        model1.setName("schneider weisse tap1");
        model1.setType("пшеничное");
        model1.setMaker("германия");
        model1.setPrice("160/120");
        model1.setVol("5,2");

        ParentItemModel model2 = new ParentItemModel(child);
        model2.setNumber("2");
        model2.setName("american lager");
        model2.setType("");
        model2.setMaker("velka morava");
        model2.setPrice("130/170");
        model2.setVol("4,6");

        ParentItemModel model3 = new ParentItemModel(child);
        model3.setNumber("3");
        model3.setName("summer of hase");
        model3.setType("juicy ipa");
        model3.setMaker("бакунин");
        model3.setPrice("180/230");
        model3.setVol("7,2");

        ParentItemModel model4 = new ParentItemModel(child);
        model4.setNumber("4");
        model4.setName("eat no dust!");
        model4.setType("dipa ddh nelson sauvin");
        model4.setMaker("af brew");
        model4.setPrice("0,4/220");
        model4.setVol("8");

        ParentItemModel model5 = new ParentItemModel(child);
        model5.setNumber("5");
        model5.setName("peach up");
        model5.setType("milkshake ipa с персиком");
        model5.setMaker("бакунин");
        model5.setPrice("0,4/200");
        model5.setVol("7,2");

        ParentItemModel model6 = new ParentItemModel(child);
        model6.setNumber("6");
        model6.setName("moloko");
        model6.setType("milk stout");
        model6.setMaker("бакунин");
        model6.setPrice("150/210");
        model6.setVol("6,5");

        ParentItemModel model7 = new ParentItemModel(child);
        model7.setNumber("7");
        model7.setName("Убить дракона");
        model7.setType("портер");
        model7.setMaker("lovecraft");
        model7.setPrice("170/220");
        model7.setVol("8");

        ParentItemModel model8 = new ParentItemModel(child);
        model8.setNumber("8");
        model8.setName("duchesse de bourgogne");
        model8.setType("flanders red ale");
        model8.setMaker("verhaeghe");
        model8.setPrice("230/290");
        model8.setVol("6,2");

        ParentItemModel model9 = new ParentItemModel(child);
        model9.setNumber("9");
        model9.setName("черный вепрь");
        model9.setType("тёмный мёд");
        model9.setMaker("mjolnir");
        model9.setPrice("130/170");
        model9.setVol("4,7");

        ParentItemModel model10 = new ParentItemModel(child);
        model10.setNumber("10");
        model10.setName("вероника решает умереть");
        model10.setType("ris. coffee version");
        model10.setMaker("plsn b");
        model10.setPrice("220/270");
        model10.setVol("13");

        ParentItemModel model11 = new ParentItemModel(child);
        model11.setNumber("11");
        model11.setName("цветочный сидр");
        model11.setType("");
        model11.setMaker("st.anton");
        model11.setPrice("140/180");
        model11.setVol("5");

        ParentItemModel model12 = new ParentItemModel(child);
        model12.setNumber("12");
        model12.setName("mort subite");
        model12.setType("вишневый ламбик");
        model12.setMaker("kriek");
        model12.setPrice("210/260");
        model12.setVol("4,3");

        elements.add(model1);
        elements.add(model2);
        elements.add(model3);
        elements.add(model4);
        elements.add(model5);
        elements.add(model6);
        elements.add(model7);
        elements.add(model8);
        elements.add(model9);
        elements.add(model10);
        elements.add(model11);
        elements.add(model12);

        return elements;
    }
}
