package com.epam.mentoring.springboot.task2.config;

import com.epam.mentoring.springboot.task2.CustomStarterService;
import com.epam.mentoring.springboot.task2.CustomStarterServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(CustomStarterService.class)
public class CustomStarterAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public CustomStarterService customStarterService() {
		return new CustomStarterServiceImpl();
	}
}
