package per.sc.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Flynn on 2018-05-09.
 */
public class MD5Util {
    private static final Logger logger = LogManager.getLogger(
            MD5Util.class);


    private static final String SALT = "ILoveYou";

    public static void main(String[] args) {
        String md5WithSalt = getMD5WithSalt("123456");
        System.out.println(md5WithSalt);
    }

    /**
     * 获取加盐的MD5字符串
     */
    public static String getMD5WithSalt(String content) {
        return getMD5(getMD5(content) + SALT);
    }

    /**
     * 获取MD5字符串
     */
    public static String getMD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return getHashString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }

}
