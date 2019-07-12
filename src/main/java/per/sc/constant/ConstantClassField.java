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


/*    public static final String UPLOAD_PATH = "/Users/Macx/Desktop/素材/";*/

    /**
     * 图片最后存储位置
     */
    public static final String UPLOAD_PATH = "F:"+ File.separator+"uploadImage"+File.separator;

    /**
     * 图片上传临时地址
     */
    public static final String TEMP_PATH = "F:"+ File.separator+"ImagePath"+File.separator;

    /**
     * 图片访问路径
     */
/*    public static final String IMAGE_URL_PATH = "http://10.233.1.34:8088/image/";*/

    public static final String IMAGE_URL_PATH = "http://10.233.1.240:8088/image/";
}

