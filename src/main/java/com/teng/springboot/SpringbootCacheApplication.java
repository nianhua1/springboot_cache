package com.teng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "com.teng.springboot.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheApplication.class, args);
	}

}
