package org.tf.module.message;


import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.apache.commons.lang.StringUtils;
import org.tf.config.GetuiConfig;
import org.tf.module.Platform;
import org.tf.module.device.GetuiDevice;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author hezhiyu on 15/5/14.
 */
public class GetuiPushMessage extends AbstractPushMessage {

    public enum MessageType {
        Single,
        List,
        App
    }

    public final Platform platform;

    public final MessageType type;

    public final Map<String, String> dataMap;

    public final GetuiDevice device;
    public final Collection<GetuiDevice> devices;

    public GetuiPushMessage(Platform platform, MessageType type, Map<String, String> dataMap, GetuiDevice device) {
        this.platform = platform;
        this.type = type;
        this.dataMap = dataMap;
        this.device = device;
        this.devices = null;
    }


    public GetuiPushMessage(Platform platform, MessageType type, Map<String, String> dataMap, Collection<GetuiDevice> devices) {
        this.platform = platform;
        this.type = type;
        this.dataMap = dataMap;
        this.device = null;
        this.devices = devices;
    }


    public SingleMessage getSingleMessage() throws Exception {
        SingleMessage singleMessage = new SingleMessage();
        singleMessage.setData(buildTransmissionTemplate(dataMap.get("content"), platform));
        singleMessage.setOffline(true);
        singleMessage.setPushNetWorkType(0);
        singleMessage.setOfflineExpireTime(60 * 1000);
        return singleMessage;
    }

    public Target getTarget() {
        Target target = new Target();
        target.setClientId(device.getClientId());
        target.setAppId(device.getAppId());
        return target;
    }

    public List<Target> getTargetList() {
        return null;
    }


    private static TransmissionTemplate buildTransmissionTemplate(String content, Platform platform) throws Exception {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(GetuiConfig.APP_ID);
        template.setAppkey(GetuiConfig.APP_KEY);
        template.setTransmissionContent(content);
        template.setTransmissionType(1);
        if (platform == Platform.IOS) {
            template.setPushInfo(StringUtils.EMPTY,
                    1,
                    content,
                    "sound",
                    "payload",  // 自定义数据？
                    content,
                    "locArgs",
                    "launchImage",
                    99);
        }
        return template;
    }
}
