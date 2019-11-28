package com.qq.enums;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/28 9:37
 */
public enum MachineChromeMap {
    lqw("Administrator", "77.0.3865.90"),
    ZQQ("360JR", "78.0.3904.105"),
    ;

    private String machineName;
    private String chromeVersion;

    public static String getChromeVersion(String machineName) {
        for (MachineChromeMap map : MachineChromeMap.values()) {
            if (map.getMachineName().equals(machineName)) {
                return map.getChromeVersion();
            }
        }
        throw new RuntimeException("根据机器名未找到谷歌浏览器版本信息");
    }

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
