package per.sc.util;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/4/23 15:45
 */
public class Test01 {

    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        System.out.println(a == b);

        System.out.println(a.equals(b));

        Double c = 2.3d;
        Double d = 2.3d;

        System.out.println(c.equals(d));
        System.out.println(c==d);

        StringBuffer e = new StringBuffer("abc");
        StringBuffer e1 = new StringBuffer("abc");

        System.out.println(e == e1);
        System.out.println(e.equals(e1));

        System.out.println(1.2f + 2.5f);

        System.out.println(5.0/3.0);
    }
}
