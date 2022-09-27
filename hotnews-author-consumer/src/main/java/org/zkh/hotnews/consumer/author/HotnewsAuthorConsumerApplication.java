package org.zkh.hotnews.consumer.author;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"org.zkh.hotnews.common","org.zkh.hotnews.consumer.author"})
@SpringBootApplication
@MapperScan("org.zkh.hotnews.common.mapper")
public class HotnewsAuthorConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotnewsAuthorConsumerApplication.class, args);
    }
}
