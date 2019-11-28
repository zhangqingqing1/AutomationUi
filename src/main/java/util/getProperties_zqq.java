package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class getProperties_zqq {



    public static String getKeyValue(String machineName) throws IOException {
        String path=System.getProperty("user.dir")+"\\src\\main\\resources\\chromeversion.properties";
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(new File(path));
        properties.load(inputStream );
        return  properties.getProperty(machineName);
    }








}
