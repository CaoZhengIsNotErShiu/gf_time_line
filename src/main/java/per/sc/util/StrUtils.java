package per.sc.util;

import org.thymeleaf.util.StringUtils;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/8 下午5:54
 * @Version 1.0
 */
public class StrUtils {

    /**
     * 截取两字符之间的字符串，str 和 start不能为null或""
     */
    public static String getCutOutString(String str, String start, String endwith) {
        if (StringUtils.isEmpty(str)) {
            return "";
        } String result = "";
        if (str.contains(start)) {
            String s1 = str.split(start)[1];
            if (endwith == null || "".equals(endwith)) {
                result = s1;
            } else {
                String[] s2 = s1.split(endwith);
                if (s2 != null) { result = s2[0];
                }
            }
        }
        return result;
    }


    /**
     * 计量字符在字符串中出现的次数
     * @param str 字符串
     * @param key 字符
     * @return
     */
    public static int StrCount(String str, String key) {
        // 计数器
        int count = 0;
        // 记录截取后的新位置
        int tmp = 0;
        // 查找key(ss),找到的地址码给tmp
        while ((tmp = str.indexOf(key)) != -1) {
//            sop("str:" + str);
            // 截取
            str = str.substring(tmp + key.length());
            // 地址码+key长度,截取后重组成新str,继续while
            // 截取指导索引位置的字符串
            // 子串第一次出现的位置+长度=下一次的起始位置
            count++;
        }
        return count;
    }

    /**
     * 计量字符在字符串中出现的次数
     * @param str 字符串
     * @param key 字符
     * @return
     */
    public static int show2(String str, String key) {
        int count = 0;
        int index = 0;
        // 循环到没有ss就停
        while ((index = str.indexOf(key, index)) != -1) {
//            sop("str:" + str);
            index = index + key.length();
            count++;
        }
        return count;
    }

}
