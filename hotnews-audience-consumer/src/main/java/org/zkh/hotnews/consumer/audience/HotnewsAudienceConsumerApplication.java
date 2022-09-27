package org.zkh.hotnews.consumer.audience;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zkh.hotnews.common.mapper")
public class HotnewsAudienceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotnewsAudienceConsumerApplication.class, args);
    }

}
