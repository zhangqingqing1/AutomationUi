package com.qq.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @description:
 * @author: lu
 * @date 2019/12/5 14:33
 */
public class EnvUtil {
    private static final String USER_NAME = System.getProperty("user.name");

    public static String driverPath() throws IOException {
        Properties properties = new Properties();
        properties.load(EnvUtil.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(USER_NAME);
        return EnvUtil.class.getResource("/drivers/chromedriver" + chromeVersion + ".exe").getPath();
    }
}
