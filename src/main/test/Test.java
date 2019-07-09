import per.sc.util.StrUtils;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午3:34
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test1(){
        String b = "://localhost:8088/image/59accd5a-6a19-4089-8dff-4ce24d182de5.jpg/";
        String b1 = b.substring(b.lastIndexOf("/"));
        String subStringB = b.substring(b.lastIndexOf("/")+1);
        System.out.println(subStringB);
    }


    @org.junit.Test
    public void test2(){
        String str = "123123123123123#在这里输入你想要说的标";
//        String cutOutString = StrUtils.getCutOutString(str, "#", "#");
//        System.out.println(cutOutString);

//        int i = str.indexOf("#");
//        String substring = str.substring(str.indexOf("#", i+1)+1);
//        System.out.println(substring);
    }








}
