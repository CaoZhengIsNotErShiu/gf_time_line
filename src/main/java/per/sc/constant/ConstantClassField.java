package per.sc.constant;

import java.io.File;

/**
 * @Disc
 * @Date: 19/7/8 下午1:34
 * @Version 1.0
 * Method One
 * 定义常量类
 * @author caozheng
 */
public final class ConstantClassField {


    /**
     * 图片最后存储位置
     */
    public static final String UPLOAD_PATH = "F:"+ File.separator+"uploadImage"+File.separator;
//
    /**
     * 图片上传临时地址
     */
    public static final String TEMP_PATH = "F:"+ File.separator+"ImagePath"+File.separator;

    /**
     * 图片访问路径
     */
    public static final String IMAGE_URL_PATH = "http://10.233.1.241:8088/image/";
//
//   public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
//
    /**
     * solr
     */
    public static final String SOLR_URL_PATH = "http://127.0.0.1:8983/solr/time_line";

    /**
     * liunx服务器路径
     */
    /**
     * 图片最后存储位置
     */
   // public static final String UPLOAD_PATH = "home"+ File.separator+"uploadImage"+File.separator;

    /**
     * 图片上传临时地址 /www/wwwroot/time_line
     */
    //public static final String TEMP_PATH = File.separator + "www"+ File.separator+"wwwroot"+File.separator+"time_line"+File.separator;

    /**
     * 图片访问路径
     */
    //public static final String IMAGE_URL_PATH = "www.ohhhs.cn/";

    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";


}

