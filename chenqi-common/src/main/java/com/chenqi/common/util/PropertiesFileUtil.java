package com.chenqi.common.util;

import org.apache.velocity.texen.util.PropertiesUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 资源文件读取工具
 * @author chenqi
 * @date 2018/05/08
 */
public class PropertiesFileUtil {
    //当打开多个资源文件时，缓存资源文件
    private static HashMap<String, PropertiesFileUtil> configMap = new HashMap();
    //打开文件时间，判断超时使用
    private Date loadTime = null;
    //资源文件
    private ResourceBundle resourceBundle = null;
    //默认资源文件
    private static final String NAME = "config";
    //缓存时间
    private static final Integer TIME_OUT = 60 * 1000;

    //私有构造方法，创建单例
    private PropertiesFileUtil(String name){
        this.loadTime = new Date();
        this.resourceBundle = ResourceBundle.getBundle(name);
    }

    public static synchronized PropertiesFileUtil getInstance(){return getInstance(NAME);}

    /**
     * 在configMap集合中查找是否有这个文件，如果没有就加入到集合中
     * @param name
     * @return
     */
    public static synchronized PropertiesFileUtil getInstance(String name){
        PropertiesFileUtil conf = configMap.get(name);
        if(null == conf){
            conf = new PropertiesFileUtil(name);
            configMap.put(name, conf);
        }
        //判断是否打开的资源文件是否超时1分钟
        if((System.currentTimeMillis() - conf.getLoadTime().getTime()) > TIME_OUT) {
            conf = new PropertiesFileUtil(name);
            configMap.put(name, conf);
        }
        return conf;
    }

    // 根据key读取value
    public String get(String key){
        try {
            String value = resourceBundle.getString(key);
            return value;
        } catch (MissingResourceException e){
            return "";
        }
    }

    //根据key读取value（整型）
    public Integer getInt(String key){
        try{
            String value = resourceBundle.getString(key);
            return Integer.parseInt(value);
        } catch(MissingResourceException e) {
            return null;
        }
    }

    //根据key读取value(布尔)
    public boolean getBool(String key){
        try{
            String value = resourceBundle.getString(key);
            if("true".equals(value)){
                return true;
            }
            return false;
        } catch(MissingResourceException e){
            return false;
        }
    }

    public Date getLoadTime() { return loadTime; }


//    public static void main(String[] args){
//        System.out.println(PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username"));
//    }
}
