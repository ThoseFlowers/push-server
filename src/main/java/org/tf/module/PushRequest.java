package org.tf.module;

import java.util.Collection;
import java.util.Map;

/**
 * @author hezhiyu on 15/5/14.
 */
public class PushRequest {

    public final PushChannel      channel;
    public final long             id;               // 当群发时, id = -1;
    public final Collection<Long> idCollection;
    public final Map<String, String> dataMap;


    public PushRequest(PushChannel channel, long id, Map<String, String> dataMap) {
        this.channel = channel;
        this.id = id;
        this.idCollection = null;
        this.dataMap = dataMap;
    }

    public PushRequest(PushChannel channel, Collection<Long> idCollection, Map<String, String> dataMap) {
        this.channel = channel;
        this.idCollection = idCollection;
        this.id = -1;
        this.dataMap = dataMap;
    }

}
