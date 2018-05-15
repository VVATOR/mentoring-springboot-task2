package com.epam.mentoring.springboot;

import com.epam.mentoring.springboot.task2.CustomStarterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootAppStarter implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootAppStarter.class);
    public static final int MIN_COUNT_REGORD_FOR_BIG_DATA = 99;
    public static final String TABLE_NAME = "USER";
    public static final String MESSAGE_BUY_BUY = "You call safe close method for spring boot application! Buy buy! ";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomStarterService customStarterService;

    private  ApplicationContext app;

    public SpringBootAppStarter(ApplicationContext app) {
        this.app = app;
    }

    public static void main(String[] args) {
        SpringBootAppStarter boot = new SpringBootAppStarter(SpringApplication.run(SpringBootAppStarter.class, args));
    }

    @Override
    public void run(String... args) throws Exception {
        if (customStarterService.isBigDataProject(jdbcTemplate, TABLE_NAME, MIN_COUNT_REGORD_FOR_BIG_DATA)){
            safeClose();
        };
        LOG.info("");

    }
    private void safeClose(){
        int exitValue = SpringApplication.exit(this.app);
        LOG.info(MESSAGE_BUY_BUY);
        System.exit(exitValue);
    }

}
