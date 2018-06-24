package craftobar.com.craftobar_32.craftobar.models;

/**
 * Created by a.zverev on 21.06.2018.
 */

public class Tap {


    private int tap;
    private Beer beer;

    public void setTap(int tap) {
        this.tap = tap;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getTap() {
        return tap;
    }

    public String getTapNumber() {
        return "" + tap;
    }

    public Beer getBeer() {
        return beer;
    }

}
