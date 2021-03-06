package cn.zqs;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication

public class AuthenticationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServerApplication.class, args);
    }

    @Profile(value = "dev")
    /**
     * 为测试环境添加相关的 Request Dumper information，便于调试
     */
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
