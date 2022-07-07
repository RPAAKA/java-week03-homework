package com.sparta.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing // 자동 업데이트!
@SpringBootApplication
public class Week03Application {

	public static void main(String[] args) {
		SpringApplication.run(Week03Application.class, args);
	}

}
