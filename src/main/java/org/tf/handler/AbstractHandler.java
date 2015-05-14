package org.tf.handler;

import org.tf.module.PushResult;
import org.tf.module.message.AbstractPushMessage;

import java.util.Collection;

/**
 * @author hezhiyu on 15/5/13.
 */
public abstract class AbstractHandler {

    public abstract PushResult push(AbstractPushMessage message);

    public abstract PushResult push(Collection<AbstractPushMessage> messages);
}
