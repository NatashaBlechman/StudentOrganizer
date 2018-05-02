package com.myschooljournal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static Properties properties;

    private static void init() throws IOException {
        properties=new Properties();
        InputStream inputStream=PropertyLoader.class.getClassLoader().getResourceAsStream("default.properties");
        properties.load(inputStream);
    }

    public static  String getProperty(String propertyName){
        if(properties==null){
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(propertyName);
    }
}
