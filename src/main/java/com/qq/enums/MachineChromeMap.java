package com.qq.enums;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/28 9:37
 */
public enum MachineChromeMap {
    luqiwei("Administrator", "77.0.3865.90")
    ;
    private String machineName;
    private String chromeVersion;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getChromeVersion() {
        return chromeVersion;
    }

    public void setChromeVersion(String chromeVersion) {
        this.chromeVersion = chromeVersion;
    }

    MachineChromeMap(String machineName, String chromeVersion) {
        this.machineName = machineName;
        this.chromeVersion = chromeVersion;
    }}
