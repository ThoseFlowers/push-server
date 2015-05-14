package org.tf.client.impl;

import org.tf.biz.DeviceInfoBiz;
import org.tf.client.IPushClient;
import org.tf.handler.getui.GetuiHandler;
import org.tf.module.PushRequest;
import org.tf.module.PushResult;
import org.tf.module.device.GetuiDevice;
import org.tf.module.message.GetuiPushMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhiyu on 15/5/14.
 */
public class PushClientImpl implements IPushClient {

    private GetuiHandler getuiHandler = GetuiHandler.instance;


    private DeviceInfoBiz deviceBiz = new DeviceInfoBiz();

    @Override
    public PushResult singlePush(PushRequest pushRequest) {
        switch (pushRequest.channel) {
            case BAIDU:
                break;
            case GETUI:
                // todo 整个应该在PushRequest中整理好
                Map<String, String> dataMap = new HashMap<>();
                dataMap.put("content", "来自重构后的Push-Server");

                GetuiDevice gd = deviceBiz.queryGetuiDeviceInfo(pushRequest.id);
                GetuiPushMessage gpm = new GetuiPushMessage(gd.getPlatform(), GetuiPushMessage.MessageType.Single, dataMap, gd);
                getuiHandler.push(gpm);
                break;
        }
        return null;
    }

    @Override
    public PushResult batchPush(Collection<PushRequest> pushRequests) {
        return null;
    }
}
