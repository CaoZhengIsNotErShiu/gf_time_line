package per.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import per.sc.util.IdWorker;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午1:42
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("per.sc.mapper")
public class TlApplication {

    public  static void main(String[] args) {
        SpringApplication.run(TlApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
