package org.tf.client;

import org.tf.client.impl.PushClientImpl;
import org.tf.module.PushChannel;
import org.tf.module.PushRequest;

/**
 * @author hezhiyu on 15/5/14.
 */
public class PushTest {

    public static void main(String[] args) {
        PushClientImpl impl = new PushClientImpl();

        PushRequest pushRequest = new PushRequest(PushChannel.GETUI, 10);
        impl.singlePush(pushRequest);
    }

}
