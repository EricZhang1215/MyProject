package com.dxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConverterServiceApp extends SpringBootServletInitializer {

    public static void main( String[] args ) {
        SpringApplication.run(ConverterServiceApp.class, args);
    }

    @Override//package
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { return builder.sources(this.getClass()); }
}
