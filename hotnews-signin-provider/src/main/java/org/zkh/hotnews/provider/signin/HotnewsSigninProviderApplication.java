package org.zkh.hotnews.provider.signin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author S9049660
 */
@SpringBootApplication
@MapperScan("org.zkh.hotnews.provider.signin.mapper")
public class HotnewsSigninProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotnewsSigninProviderApplication.class, args);
    }

}
