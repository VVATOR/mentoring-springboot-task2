package com.epam.mentoring.springboot.repository.impl;

import java.sql.Types;
import java.util.Random;
import javax.annotation.Resource;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserCustomRepositoryImpl  implements UserCustomRepository{
  @Resource
  private JdbcTemplate jdbcTemplate;

  public void generateUsers(int count) {
    Random r = new Random();
    int Low = 1;
    int High = 10;
    DataFactory dataFactory = new DataFactory();
    for (int i = 0; i < count; i++) {
      Object[] paramsUsers = {dataFactory.getFirstName(), dataFactory.getLastName(), new java.sql.Date(dataFactory.getBirthDate().getTime())};
      int[] typesUsers = {Types.VARCHAR, Types.VARCHAR, Types.DATE};
      jdbcTemplate.update("Insert Into user (name, surname, birth) Values (?,?,?)", paramsUsers, typesUsers);

      int maxCountFriendRandom = r.nextInt(High-Low) + Low;
      for (int j = 0; j < maxCountFriendRandom ; j++) {
        Object[] params = {i, dataFactory.getNumberBetween(1,count), new java.sql.Date(dataFactory.getBirthDate().getTime())};
        int[] types = {Types.INTEGER, Types.INTEGER, Types.TIMESTAMP};
        jdbcTemplate.update("Insert Into friendships (userid1, userid2, timestamp) Values (?,?,?)", params, types);
      }
    }

  }

}
