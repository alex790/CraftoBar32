package craftobar.com.craftobar_32.craftobar.util;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by a.zverev on 22.05.2018.
 */

public class CbThreadPoolExecuror {


    private final Handler mHandler;
    private ExecutorService executorService;


    public CbThreadPoolExecuror() {
        mHandler = new Handler(Looper.getMainLooper());
        executorService = Executors.newCachedThreadPool();
    }


    public void execute(Runnable task) {
        executorService.execute(task);
    }


    public void execureInUiThread(Runnable task) {
        mHandler.post(task);
    }


    public Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }
}
