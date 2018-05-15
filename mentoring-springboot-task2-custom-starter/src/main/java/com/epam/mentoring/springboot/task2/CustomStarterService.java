package com.epam.mentoring.springboot.task2;

import org.springframework.jdbc.core.JdbcTemplate;

public interface CustomStarterService {

    boolean isBigDataProject(JdbcTemplate jdbcTemplate, String tableName, int limitCountRegord);

}
