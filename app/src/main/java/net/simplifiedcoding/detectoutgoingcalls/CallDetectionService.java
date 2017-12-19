package net.simplifiedcoding.detectoutgoingcalls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Belal on 9/13/2015.
 */
public class CallDetectionService extends Service {

    private CallDetector callDetector;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        callDetector = new CallDetector(this);
        int r = super.onStartCommand(intent, flags, startId);
        callDetector.start();
        return r;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        callDetector.stop();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
