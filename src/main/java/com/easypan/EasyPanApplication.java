package com.easypan;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.easypan.mapper")
@PropertySource("classpath:application.properties")
@Slf4j
public class EasyPanApplication {
  public static void main(String[] args) {
    log.info("404 Drive 启动成功！！！");
    SpringApplication.run(EasyPanApplication.class, args);
  }
}
