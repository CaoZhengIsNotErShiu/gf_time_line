package test;

import org.mybatis.generator.api.ShellRunner;

/**
 * @author zhuxiaomeng
 * @date 2017/12/4.
 * @email 154040976@qq.com
 */
public class MybatisApp {

  public static void main(String[] args) {

    args = new String[] { "-configfile", "/studyProGit/gf_time_line/src/main/resources/auto-config/mybatis-config.xml", "-overwrite" };
    ShellRunner.main(args);
  }

}
