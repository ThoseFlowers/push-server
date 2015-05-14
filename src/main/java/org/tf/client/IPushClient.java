package org.tf.client;

import org.tf.module.PushRequest;
import org.tf.module.PushResult;

import java.util.Collection;


/**
 * @author hezhiyu on 15/5/13.
 */
public interface IPushClient {

    public PushResult singlePush(PushRequest pushRequest);

    public PushResult batchPush(Collection<PushRequest> pushRequests);
}
