package per.sc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午1:54
 * @Version 1.0
 */
public class FileUtils {


    /**
     * 删除文件
     * @param path
     */
    public static void delFile(String path){
        File file=new File(path);
        if(file.exists()&&file.isFile()){
            file.delete();
        }
    }

    /**
     * 复制单个文件
     *
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            //文件存在时
            if (oldfile.exists()) {
                //读入原文件
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    //字节数 文件大小
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

}
