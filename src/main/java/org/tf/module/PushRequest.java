package org.tf.module;

import java.util.Collection;

/**
 * @author hezhiyu on 15/5/14.
 */
public class PushRequest {

    public final PushChannel      channel;
    public final long             id;               // 当群发时, id = -1;
    public final Collection<Long> idCollection;


    public PushRequest(PushChannel channel, long id) {
        this.channel = channel;
        this.id = id;
        this.idCollection = null;
    }

    public PushRequest(PushChannel channel, Collection<Long> idCollection) {
        this.channel = channel;
        this.idCollection = idCollection;
        this.id = -1;
    }

}
