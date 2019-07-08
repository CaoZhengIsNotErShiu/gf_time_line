package per.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午1:42
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("per.sc.mapper")
public class TLApplication {

    public static void main(String[] args) {
        SpringApplication.run(TLApplication.class, args);
    }
}
