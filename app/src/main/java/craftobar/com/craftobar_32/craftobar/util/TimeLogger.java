package craftobar.com.craftobar_32.craftobar.util;

import android.util.Log;
import java.util.HashMap;


/**
 * Created by a.zverev on 22.05.2018.
 */
public class TimeLogger {

    private static long simpleTimeLoger = 0;
    private static HashMap<String,Long> times = new HashMap<>();


    public static void startSimpleTimeLoger() {
        simpleTimeLoger = System.currentTimeMillis();
    }


    public static long stopSimpleTimeLoger(String tag) {

        long time = System.currentTimeMillis() - simpleTimeLoger;
        Log.d("TimeLogger", tag + " " + time);

        return time;
    }


    public static void startTimer(String nameTimer) {
        times.put(nameTimer, System.currentTimeMillis());
    }


    public static long stopTimer(String nameTimer) {

        Long loger = times.get(nameTimer);
        long time = loger == null ? -1 : System.currentTimeMillis() - loger;

        Log.d("TimeLogger", nameTimer + " " + time);

        return time;
    }

}
