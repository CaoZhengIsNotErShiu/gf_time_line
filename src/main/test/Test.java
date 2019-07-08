import per.sc.pojo.TimeLinePOJO;

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
        TimeLinePOJO pojo = new TimeLinePOJO();
        pojo.setContent("111");
        pojo.setImageUrl("213123");
    }


}
