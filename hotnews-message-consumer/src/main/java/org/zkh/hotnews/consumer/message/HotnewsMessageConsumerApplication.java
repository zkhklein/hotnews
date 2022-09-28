package org.zkh.hotnews.consumer.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author S9049660
 */
@ComponentScan({"org.zkh.hotnews.common", "org.zkh.hotnews.consumer.message"})
@SpringBootApplication
@MapperScan("org.zkh.hotnews.common.mapper")
public class HotnewsMessageConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotnewsMessageConsumerApplication.class, args);
    }
}
