package per.sc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.sc.pojo.ArticleVO;
import per.sc.service.ArticleServiceI;
import per.sc.util.DateUtil;
import per.sc.util.HtmlToText;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/12/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private ArticleServiceI artService;


    @Autowired
    private HttpSession session;

    @Test
    public void testSession(){
//        session.setAttribute("15651367595","789456");
        String attribute = (String) session.getAttribute("15651367595");
        System.out.println(attribute);
    }

    @Test
    public void getFileJpg(){
//        String date = DateUtil.getStringAllDate();
//        String path = UUID.randomUUID().toString().replaceAll("-","")+"-"+ date + ".jpg";
//        System.out.println(path);

        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-2);
        Date d=cal.getTime();

        SimpleDateFormat sp=new SimpleDateFormat("yyyyMMdd");
        //获取昨天日期
        String yesterday = sp.format(d);
        System.out.println(yesterday);

        String pathName = "F://intentImage/";
        File file = new File(pathName);
//        if (file.exists()){
//            String[] list = file.list();
//            Stream<String> stream = Stream.of(list);
////            List<ArticleVO> artList =  artService.queryYesterdayArt();
//            artList.stream()
//                    .filter(articleVO -> !articleVO.getData().contains(yesterday))
//                    .forEach(s -> System.out.println(HtmlToText.getImageSrc(s.getData())));
////            stream.filter(s -> s.contains(yesterday))
//////                    .forEach(System.out::println);
////                    .forEach(s -> new File(pathName+s).delete());
//
//
//        }
    }

    /**
     * 筛选出张姓字符，长度为2的字符
     */
    @Test
    public void streamTest01(){
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 2)
                .forEach(System.out :: println);
    }

    /**
     * 筛选出张姓字符，长度为2的字符
     */
    @Test
    public void streamTest02(){
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream()
                .forEach(System.out :: println);
    }


    @Test
    public void threadTest01(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程被调用了。。");
            }
        };
        new Thread(task).start();
    }

    @Test
    public void threadLambdaTest01(){
        new Thread(() -> System.out.println("多线程被调用")).start();
    }



//
//    @Test
//    public void Test01(){
//        List<ArticleVO> list = artService.queryIndexInfo();
//        System.out.println(list.toString());
//    }

    @Test
    public void test02(){
        ArrayList names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        ArrayList names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        sortUsingJava7(names1);
        System.out.println(names1);
        sortUsingJava8(names2);
        System.out.println(names2);
    }

    @Test
    public void test03(){
        MathOperation add = (int a, int b) -> a + b;

        System.out.println(add.abc(5,6));
    }

    interface MathOperation {
        int abc(int a, int b);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names);
    }


    @Test
    public void test04(){
        String userName = "123123-456789";
        String str1=userName.substring(0, userName.indexOf("-"));
        String str2=userName.substring(str1.length()+1, userName.length());
        System.out.println(str2);
    }
}
