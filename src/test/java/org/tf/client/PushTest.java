package org.tf.client;

import org.tf.client.impl.PushClientImpl;
import org.tf.constants.PushServerConstants;
import org.tf.module.PushChannel;
import org.tf.module.PushRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author hezhiyu on 15/5/14.
 */
public class PushTest {

    public static void main(String[] args) {


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            PushClientImpl impl = new PushClientImpl();
            int i = 0;
            @Override
            public void run() {
                i++;
                Map<String, String> dataMap = new HashMap<>();
                dataMap.put(PushServerConstants.PUSH_CONTENT, "conter: " + i);
                PushRequest pushRequest = new PushRequest(PushChannel.GETUI, 10, dataMap);
                impl.singlePush(pushRequest);
            }
        }, 0, 1000 * 3 /* 10s */);

    }

}
