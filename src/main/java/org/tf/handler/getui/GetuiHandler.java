package org.tf.handler.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import org.tf.config.GetuiConfig;
import org.tf.handler.AbstractHandler;
import org.tf.module.Platform;
import org.tf.module.PushResult;
import org.tf.module.message.AbstractPushMessage;
import org.tf.module.message.GetuiPushMessage;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author hezhiyu on 15/5/13.
 */
public class GetuiHandler extends AbstractHandler {

    public static final GetuiHandler instance;

    static {
        instance = new GetuiHandler();
        try {
            instance.initIGtPush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IGtPush iGtPush;

    private GetuiHandler() {

    }

    private void initIGtPush() throws IOException {
        iGtPush = new IGtPush(GetuiConfig.HOST, GetuiConfig.APP_KEY, GetuiConfig.MASTER);
        iGtPush.connect();
    }

    @Override
    public PushResult push(AbstractPushMessage pr) {
        PushResult pushResult;
        try {
            IPushResult ret = null;
            GetuiPushMessage gpm = (GetuiPushMessage)pr;
            if (gpm.platform == Platform.ANDROID) {
                switch (gpm.type) {
                    case Single:
                        ret = push2Android(gpm.getSingleMessage(), gpm.getTarget());
                        break;
                    case List:
                        break;
                    case App:
                        break;
                }
            } else if (gpm.platform == Platform.IOS) {
                switch (gpm.type) {
                    case Single:
                        ret = push2IOS(gpm.device.getAppId(), gpm.device.getDeviceToken(), gpm.getSingleMessage());
                        break;
                    case List:
                        break;
                    case App:
                        break;
                }
            }

            System.out.println(ret.getResponse().toString());
            pushResult = new PushResult();
        } catch (Exception e) {
            pushResult = PushResult.buildError();
            e.printStackTrace();
        }
        return pushResult;
    }

    @Override
    public PushResult push(Collection<AbstractPushMessage> pushRequest) {
        return null;
    }



    public IPushResult push2Android(SingleMessage singleMessage, Target target) {
        return iGtPush.pushMessageToSingle(singleMessage, target);
    }

    public IPushResult push2IOS(String appId, String deviceToken, SingleMessage singleMessage) {
        return iGtPush.pushAPNMessageToSingle(appId, deviceToken, singleMessage);
    }

    public IPushResult push2Android(String content, List<Target> targets) {
        return iGtPush.pushMessageToList(content, targets);
    }


}