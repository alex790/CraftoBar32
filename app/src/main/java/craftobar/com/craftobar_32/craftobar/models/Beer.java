package craftobar.com.craftobar_32.craftobar.models;

/**
 * Created by a.zverev on 21.06.2018.
 */

public class Beer {


    private String name;
    private String type;
    private String manufacturer;
    private String alcohol;
    private String description;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

}
