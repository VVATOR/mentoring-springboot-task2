package com.epam.mentoring.springboot.beans;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "friendships")
public class Friendships {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "userid1")
  private Integer userId1;

  @Column(name = "userid2")
  private Integer userId2;

  @Column(name = "timestamp")
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private Timestamp timestamp;

  public Friendships() {
  }

  public Friendships(Integer userId1, Integer userId2, Timestamp timestamp) {
    this.userId1 = userId1;
    this.userId2 = userId2;
    this.timestamp = timestamp;
  }

  public Friendships(Integer userId2, Timestamp timestamp) {
    this.userId2 = userId2;
    this.timestamp = timestamp;
  }

  public Integer getUserId1() {
    return userId1;
  }

  public void setUserId1(Integer userId1) {
    this.userId1 = userId1;
  }

  public Integer getUserId2() {
    return userId2;
  }

  public void setUserId2(Integer userId2) {
    this.userId2 = userId2;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Friendships{" +
        "userId1=" + userId1 +
        ", userId2=" + userId2 +
        ", timestamp=" + timestamp +
        '}';
  }
}
