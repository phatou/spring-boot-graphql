package com.example.springbootgraphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

  private UserService userService;

  public Mutation(UserService userService) {
    this.userService = userService;
  }

  public User createUser(String login, String name) {
    return this.userService.addUser(login, name);
  }
}
