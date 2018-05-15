package com.epam.mentoring.springboot.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomStarterServiceImpl implements CustomStarterService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomStarterServiceImpl.class);
    public static final String STRING_SQL_QUERY_COUNT = "SELECT COUNT(0) FROM ";
    public static final String MESSAGE_TABLE_ROW_COUNT = "TABLE ROW COUNT: ";
    public static final String MESSAGE_BIG_DATA = "It's BigData project";
    public static final String MESSAGE_SMALL_DATA = "It's SmallData project";

    public boolean isBigDataProject(JdbcTemplate jdbcTemplate, String tableName, int limitCountRegord) {
        final String SQL = STRING_SQL_QUERY_COUNT + tableName;
        Integer result = jdbcTemplate.queryForObject(SQL, Integer.class);
        int count = (result != null ? result : 0);

        LOG.info(MESSAGE_TABLE_ROW_COUNT + count);

        if (count >= limitCountRegord) {
            LOG.info(MESSAGE_BIG_DATA);
            return true;
        }
        LOG.info(MESSAGE_SMALL_DATA);
        return false;
    }
}
