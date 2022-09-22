package org.zkh.hotnews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author zkh
 */
@SpringBootApplication
@MapperScan("org.zkh.hotnews.mapper")
@ComponentScan("org.zkh.hotnews")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
