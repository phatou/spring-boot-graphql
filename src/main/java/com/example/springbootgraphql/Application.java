package com.example.springbootgraphql;

import com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = GraphQLWebAutoConfiguration.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  ApplicationRunner run(UserService userService) {
    return args -> {
      Stream.of(
          "javadevjournal:Java Dev Journal",
          "octocat:The Octocat",
          "guest:From Another Universe"
      ).forEach(data -> {
        User user = new User();
        String[] fields = data.split(":");
        user.setLogin(fields[0]);
        user.setName(fields[1]);
        userService.saveUser(user);
      });
      userService.getAllUsers().forEach(System.out::println);
    };
  }
}
