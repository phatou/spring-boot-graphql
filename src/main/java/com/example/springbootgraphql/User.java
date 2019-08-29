package com.example.springbootgraphql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class User {

  @Id
  @GeneratedValue
  private int id;

  private String login;

  private String name;
}
