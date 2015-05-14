package org.tf.biz;

import org.tf.config.GetuiConfig;
import org.tf.module.device.GetuiDevice;

/**
 * @author hezhiyu on 15/5/14.
 */
public class DeviceInfoBiz {

    public GetuiDevice queryGetuiDeviceInfo(long id) {
        GetuiDevice device = new GetuiDevice();
        device.setClientId(GetuiConfig.CLIENT_ID);
        device.setAppId(GetuiConfig.APP_ID);
//        device.setPlatform(2);
        device.setPlatform(1);
        device.setDeviceToken(GetuiConfig.DEVICE_TOKEN);
        return device;
    }

    

}
