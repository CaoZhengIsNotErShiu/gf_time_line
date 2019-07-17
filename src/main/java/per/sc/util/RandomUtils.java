package per.sc.util;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
public class RandomUtils {

    /**
     * random.nextInt(10) 生成 0-9 之间的随机数；
     * 生成6次，拼接成字符串
     * @return
     */
    public static String randomCode(){
        java.util.Random random = new java.util.Random();
        String result = "";
        for(int j = 0; j < 6; j++){
            result += random.nextInt(10);
        }
        return result;
    }
}
