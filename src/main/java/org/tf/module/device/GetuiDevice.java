package org.tf.module.device;

import org.tf.module.Platform;

/**
 * @author hezhiyu on 15/5/14.
 */
public class GetuiDevice {

    private int platform;
    private String clientId;
    private String appId;
    private String deviceToken;

    public GetuiDevice() {

    }
    public Platform getPlatform() {
        return Platform.values()[platform];
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
