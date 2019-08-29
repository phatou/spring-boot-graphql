package com.example.springbootgraphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

  private UserService service;

  public Query(UserService service) {
    this.service = service;
  }

  //public List<User> getUsers() {
  //  return this.repository.findAll();
  //}

  public List<User> getUsers(int first, int last) {
    System.out.println("Query: [" + first + "] to [" + last + "]");
    if (first == 0 && last == 0) {
      return this.service.getAllUsers();
    } else {
      return this.service.getUsers(first, last);
    }
  }

  public Optional<User> getUser(int id) {
    return this.service.getUser(id);
  }
}
